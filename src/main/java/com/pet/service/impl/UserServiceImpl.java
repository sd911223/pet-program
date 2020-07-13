package com.pet.service.impl;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pet.bean.dto.req.LoginRqe;
import com.pet.bean.dto.req.ReportReq;
import com.pet.common.RestResponse;
import com.pet.common.ResultUtil;
import com.pet.dao.PetUserMapper;
import com.pet.dao.ReportUserInfoMapper;
import com.pet.model.PetUser;
import com.pet.model.PetUserExample;
import com.pet.service.UserService;
import com.pet.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    PetUserMapper petUserMapper;
    @Value("${shangBao.url}")
    private String url;

    @Value("${baiduAddress.url}")
    private String baiDuUrl;

    @Value("${baiduAddress.key}")
    private String baiDuKey;

    @Autowired
    ReportUserInfoMapper reportUserInfoMapper;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public PetUser findByOpenid(String openid) {
        PetUser petUser = null;
        PetUserExample petUserExample = new PetUserExample();
        petUserExample.createCriteria().andOpenIdEqualTo(openid);
        List<PetUser> userList = petUserMapper.selectByExample(petUserExample);
        if (userList.isEmpty()) {
            return petUser;
        } else {
            petUser = userList.get(0);
        }
        return petUser;
    }

    @Override
    public RestResponse<String> login(LoginRqe loginRqe) {
        String token = "";
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("用户非敏感信息" + loginRqe.getRawData());

        JSONObject rawDataJson = JSON.parseObject(loginRqe.getRawData());

        System.out.println("签名" + loginRqe.getSignature());
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId(loginRqe.getCode());
        System.out.println("post请求获取的SessionAndopenId=" + SessionKeyOpenId);

        String openid = SessionKeyOpenId.getString("openid");

        String sessionKey = SessionKeyOpenId.getString("session_key");

        System.out.println("openid=" + openid + ",session_key=" + sessionKey);

        PetUser user = findByOpenid(openid);
        //uuid生成唯一key
        String skey = UUID.randomUUID().toString();
        if (user == null) {
            //入库
            String nickName = rawDataJson.getString("nickName");
            String avatarUrl = rawDataJson.getString("avatarUrl");
            String gender = rawDataJson.getString("gender");
            String city = rawDataJson.getString("city");
            String country = rawDataJson.getString("country");
            String province = rawDataJson.getString("province");
            user = saveUser(openid, sessionKey, province, city, country, avatarUrl, nickName, gender);
        } else {
            token = jwtUtils.generateToken(user.getId());

            //已存在
            log.info("用户openid已存在,不需要插入");
            return ResultUtil.success(token);
        }
        //根据openid查询skey是否存在
//        String skey_redis = (String) redisTemplate.opsForValue().get( openid );
//        if(StringUtils.isNotBlank( skey_redis )){
//            //存在 删除 skey 重新生成skey 将skey返回
//            redisTemplate.delete( skey_redis );
//
//        }
        //  缓存一份新的
        JSONObject sessionObj = new JSONObject();
        sessionObj.put("openId", openid);
        sessionObj.put("sessionKey", sessionKey);
//        redisTemplate.opsForValue().set( skey,sessionObj.toJSONString() );
//        redisTemplate.opsForValue().set( openid,skey );

//        把新的sessionKey和oppenid返回给小程序
//        map.put("skey", skey);

        JSONObject userInfo = getUserInfo(loginRqe.getEncrypteData(), sessionKey, loginRqe.getIv());
        System.out.println("根据解密算法获取的userInfo=" + userInfo);
//        userInfo.put( "balance",user.getUbalance() );
        token = jwtUtils.generateToken(user.getId());
        map.put("userInfo", userInfo);


        return ResultUtil.success(token);
    }

    @Override
    public PetUser findByUserId(Integer userId) {
        PetUser petUser = petUserMapper.selectByPrimaryKey(userId);
        return petUser;
    }


    private PetUser saveUser(String openid, String sessionKey, String province, String city, String country, String avatarUrl, String nickName, String gender) {
        PetUser user = new PetUser();
        user.setOpenId(openid);
        user.setCreateTime(new Date());
        user.setSessionKey(sessionKey);
        user.setUbalance(0);
        user.setProvince(province);
        user.setCity(city);
        user.setCountry(country);
        user.setAvatarUrl(avatarUrl);
        user.setGender(Integer.parseInt(gender));
        user.setNickName(nickName);
        user.setUpdateTime(new Date());

        petUserMapper.insertSelective(user);
        return user;
    }

    /**
     * 获取sessionkey
     *
     * @param code
     * @return
     */
    public static JSONObject getSessionKeyOrOpenId(String code) {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        StringBuilder sb = new StringBuilder();
        sb.append(requestUrl);
        sb.append("?appid=");
        sb.append("wx90ddf0872a66b2ea");
        sb.append("&secret=");
        sb.append("6715b9f17262d77d055db4b94b0b0c5c");
        sb.append("&js_code=");
        sb.append(wxCode);
        sb.append("&grant_type=authorization_code");
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        //小程序appId
        requestUrlParam.put("appid", "wx90ddf0872a66b2ea");
        requestUrlParam.put("secret", "6715b9f17262d77d055db4b94b0b0c5c");
        //小程序端返回的code
        requestUrlParam.put("js_code", wxCode);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(sb.toString(), String.class);
        log.info(JSONObject.toJSONString(s).toString());
        JSONObject jsonObject = JSON.parseObject(s);
        return jsonObject;
    }

    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = cn.hutool.core.codec.Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = cn.hutool.core.codec.Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidParameterSpecException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchProviderException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public RestResponse report(ReportReq reportReq) {
        log.info("获取小程序内容:{}", JSON.toJSONString(reportReq));
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isBlank(reportReq.getMobile()) || null == reportReq.getMobile()) {
            jsonObject.put("telnumber", "");
        } else {
            jsonObject.put("telnumber", reportReq.getMobile());
        }
        jsonObject.put("areaCode","654301000000");
        jsonObject.put("lat", reportReq.getLongitude());
        jsonObject.put("lng", reportReq.getLatitude());
        jsonObject.put("uuid", UUID.randomUUID());
        jsonObject.put("sendTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, jsonObject.toJSONString(), String.class);
        log.info("上报返回结果:{}", result);
        return ResultUtil.success();
    }
}
