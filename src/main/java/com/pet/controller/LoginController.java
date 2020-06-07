package com.pet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pet.common.RestResponse;
import com.sun.jndi.toolkit.url.UrlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "登录")
@RestController
@RequestMapping("/petApi")
@Slf4j
public class LoginController {
    /**
     * 登陆接口
     */
    @PostMapping("/weChat/login")
    @ApiOperation(value = "小程序登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "临时登录凭证code", required = true),
            @ApiImplicitParam(name = "rawData", value = "用户非敏感信息", required = true),
            @ApiImplicitParam(name = "signature", value = "签名", required = true),
            @ApiImplicitParam(name = "encrypteData", value = "用户敏感信息", required = true),
            @ApiImplicitParam(name = "iv", value = "解密算法的向量", required = true)})
    public RestResponse<Object> login(String code, String rawData, String signature, String encrypteData, String iv) {
        log.info("Start get SessionKey");


        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("用户非敏感信息" + rawData);

        JSONObject rawDataJson = JSON.parseObject(rawData);

        System.out.println("签名" + signature);
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId(code);
        System.out.println("post请求获取的SessionAndopenId=" + SessionKeyOpenId);

        String openid = SessionKeyOpenId.getString("openid");

        String sessionKey = SessionKeyOpenId.getString("session_key");

        System.out.println("openid=" + openid + ",session_key=" + sessionKey);
//
//        User user = userService.findByOpenid( openid );
//        //uuid生成唯一key
//        String skey = UUID.randomUUID().toString();
//        if(user==null){
//            //入库
//            String nickName = rawDataJson.getString( "nickName" );
//            String avatarUrl = rawDataJson.getString( "avatarUrl" );
//            String gender  = rawDataJson.getString( "gender" );
//            String city = rawDataJson.getString( "city" );
//            String country = rawDataJson.getString( "country" );
//            String province = rawDataJson.getString( "province" );
//
//
//            user = new User();
//            user.setUid( openid );
//            user.setCreateTime( new Date(  ) );
//            user.setSessionkey( sessionKey );
//            user.setUbalance( 0 );
//            user.setSkey( skey );
//            user.setUaddress( country+" "+province+" "+city );
//            user.setUavatar( avatarUrl );
//            user.setUgender( Integer.parseInt( gender ) );
//            user.setUname( nickName );
//            user.setUpdateTime( new Date(  ) );
//
//            userService.insert( user );
//        }else {
//            //已存在
//            log.info( "用户openid已存在,不需要插入" );
//        }
//        //根据openid查询skey是否存在
//        String skey_redis = (String) redisTemplate.opsForValue().get( openid );
//        if(StringUtils.isNotBlank( skey_redis )){
//            //存在 删除 skey 重新生成skey 将skey返回
//            redisTemplate.delete( skey_redis );
//
//        }
//        //  缓存一份新的
//        JSONObject sessionObj = new JSONObject(  );
//        sessionObj.put( "openId",openid );
//        sessionObj.put( "sessionKey",sessionKey );
//        redisTemplate.opsForValue().set( skey,sessionObj.toJSONString() );
//        redisTemplate.opsForValue().set( openid,skey );
//
//        //把新的sessionKey和oppenid返回给小程序
//        map.put( "skey",skey );
//
//
//
//        map.put( "result","0" );
//
//
//
//        JSONObject userInfo = getUserInfo( encrypteData, sessionKey, iv );
//        System.out.println("根据解密算法获取的userInfo="+userInfo);
//        userInfo.put( "balance",user.getUbalance() );
//        map.put( "userInfo",userInfo );


        return null;
    }

    public static JSONObject getSessionKeyOrOpenId(String code) {
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        //小程序appId
        requestUrlParam.put("appid", "wx90ddf0872a66b2ea");
        requestUrlParam.put("secret", "c7b2484b7a286bce3bfc4024b158491c");
        //小程序端返回的code
        requestUrlParam.put("js_code", wxCode);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(requestUrl, requestUrlParam, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        return jsonObject;
    }

}
