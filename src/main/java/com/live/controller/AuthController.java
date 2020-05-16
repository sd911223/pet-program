package com.live.controller;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.common.ResultUtil;
import com.live.model.DTO.MPWechatAuthDTO;
import com.live.model.LiveUser;
import com.live.model.WxUserInfo;
import com.live.service.MiniProgramService;
import com.live.service.WechatUserInterface;
import com.live.util.MD5Util;
import com.live.util.StringUtil;
import com.live.util.WXCore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shitou
 */
@RestController
@Api(tags = "小程序授权登录")
@RequestMapping("/api/wechat")
public class AuthController {

    @Autowired
    private MiniProgramService miniProgramService;
    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;
    @Autowired
    private WechatUserInterface wechatUserInterface;

    @ApiOperation("授权")
    @PostMapping("/mp_auth")
    @ApiImplicitParams({@ApiImplicitParam(name = "spread_spid", example = "0"),
            @ApiImplicitParam(value = "spread_code", required = true),
            @ApiImplicitParam(name = "iv", required = true),
            @ApiImplicitParam(name = "encryptedData", required = true),
            @ApiImplicitParam(name = "code", required = true),
            @ApiImplicitParam(name = "cache_key", required = true),
            @ApiImplicitParam(name = "login_type", example = "routine")
    })
    public RestResponse mp_auth(MPWechatAuthDTO mpWechatAuthDTO) {

        // 获取请求参数，封装成对象
        String cacheKey = null;
        // 获取sessionKey
        String sessionKey = ehCacheCacheManager.getCache("myCache")
                .get("jm_api_code:"+mpWechatAuthDTO.getCache_key()).toString();
        //
        WxUserInfo wxUserInfo = null;

        if(StringUtil.isNull(mpWechatAuthDTO.getCode()) && StringUtil.isNull(sessionKey)) {
            return new RestResponse(200, "授权失败,参数有误",null);
        }

        if(StringUtil.isNotNull(mpWechatAuthDTO.getCode()) && StringUtil.isNull(sessionKey) ) {

            if (StringUtil.isNotNull(mpWechatAuthDTO.getEncryptedData())) {
                try {
                    JSONObject userInfoCong = miniProgramService.getUserInfo(mpWechatAuthDTO.getCode());
                    sessionKey = userInfoCong.getString("session_key'");
                    cacheKey = MD5Util.toMd5("code");

                    // 加入缓存
                    ehCacheCacheManager.getCache("myCache").put("api_code:" + cacheKey, sessionKey);
                } catch (Exception e) {
                    return new RestResponse(-41003, "获取session_key失败，请检查您的配置1！", null);
                }


                try {
                    //解密获取用户信息
                    //String appId, String encryptedData, String sessionKey, String iv
                    String userInfoStr = WXCore.decrypt("", mpWechatAuthDTO.getEncryptedData(), sessionKey, mpWechatAuthDTO.getIv());
                    wxUserInfo = JSONObject.parseObject(userInfoStr,WxUserInfo.class);
                } catch (Exception e) {
                    return new RestResponse(-41003, "获取会话密匙失败", null);
                }
            } else {
                JSONObject userInfo = miniProgramService.notPowerOpenid(mpWechatAuthDTO.getCode());
                if (userInfo.containsKey("openid") && userInfo.getString("openid") != null) {
                    wxUserInfo.setOpenId(userInfo.getString("openid"));
                    wxUserInfo.setUser_type("routine");
                } else {
                    return new RestResponse(2, "获取用户信息失败", null);
                }
            }
        }else {
            try {
                //解密获取用户信息
                //String appId, String encryptedData, String sessionKey, String iv
                String userInfoStr = WXCore.decrypt("", mpWechatAuthDTO.getEncryptedData(), sessionKey, mpWechatAuthDTO.getIv());
                wxUserInfo = JSONObject.parseObject(userInfoStr,WxUserInfo.class);
            } catch (Exception e) {
                return new RestResponse(-41003, "获取会话密匙失败", null);
            }
        }


        if (StringUtil.isNotNull(wxUserInfo.getOpenId())) {
            return new RestResponse(2, "openid获取失败!", null);
        }

        if (StringUtil.isNotNull(wxUserInfo.getUnionId())) {
            wxUserInfo.setUnionId("");
        }

        wxUserInfo.setSpid(mpWechatAuthDTO.getSpread_spid());
        wxUserInfo.setCode(mpWechatAuthDTO.getSpread_code());
        wxUserInfo.setSession_key(sessionKey);
        wxUserInfo.setLogin_type(mpWechatAuthDTO.getLogin_type());

        // 创建或更新用户信息
        LiveUser liveUser =  wechatUserInterface.routineOauth(wxUserInfo);

        /*if ("h5".equals(liveUser.getLogin_type())) {
            $token = UserToken::createToken ($userInfo, 'routine');
        }else {
            $token = UserToken::createToken ($userInfo, 'routine');
        }
        if ($token) {
            event('UserLogin', [$userInfo, $token]);
            return app('json')->successful('登陆成功！', [
                    'token'        => $token['token'],
                    'userInfo'     => $userInfo,
                    'expires_time' => strtotime($token['expires_time']),
                    'cache_key'    => $cache_key,
            ]);
        } else {
            return new RestResponse(2, "获取用户访问token失败!", null);
        }
*/

        return ResultUtil.success();
    }

    private String createToken() {

        return null;
    }


    @ApiOperation("授权")
    @PostMapping("/mp_auth_store_info")
    public RestResponse mp_auth_store_info(HttpServletRequest request) {

        String code = request.getParameter("code");
        String login_type = request.getParameter("login_type");
        String routine = request.getParameter("routine");

        JSONObject userInfo = miniProgramService.notPowerOpenid(code);


        return  null;
    }

    @ApiOperation("授权")
    @PostMapping("/mp_store_get")
    public RestResponse mp_auth_store_get(HttpServletRequest request) {

        String openid = request.getParameter("openid");
        String lng = request.getParameter("lng");
        String lat = request.getParameter("lat");
        String store_id = request.getParameter("store_id");
        String clerk_id = request.getParameter("clerk_id");

       // JSONObject userInfo = miniProgramService.notPowerOpenid(code);

        return  null;
    }
}
