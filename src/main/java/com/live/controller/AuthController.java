package com.live.controller;

import com.live.common.RestResponse;
import com.live.common.ResultUtil;
import com.live.model.DTO.MPWechatAuthDTO;
import com.live.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shitou
 */
@RestController
@Api(tags = "小程序授权登录")
@RequestMapping("/api/wechat")
public class AuthController {

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

        // 获取sessionKey
        String sessionKey = "";

        if(StringUtil.isNull(mpWechatAuthDTO.getCode()) && StringUtil.isNull(sessionKey)) {
            return new RestResponse(200, "授权失败,参数有误",null);
        }

        if(StringUtil.isNotNull(mpWechatAuthDTO.getCode()) && StringUtil.isNull(sessionKey) ) {

            if(StringUtil.isNotNull(mpWechatAuthDTO.getEncryptedData())){
                try {
                    $userInfoCong = MiniProgramService::getUserInfo ($data['code']);
                    $session_key = $userInfoCong['session_key'];
                    $cache_key = md5(time().$data['code']);
                    Cache::set ('api_code:'.$cache_key, $session_key, 150);
                }catch (Exception e) {
                    return new RestResponse(-41003, "获取session_key失败，请检查您的配置1！",null);
                }


                try {
                    //解密获取用户信息
                    $userInfo = MiniProgramService::encryptor($session_key, $data['iv'], $data['encryptedData']);
                } catch (Exception e) {
                    return new RestResponse(-41003, "获取会话密匙失败",null);
                }
            }else {
                $userInfo = MiniProgramService::notPowerOpenid($data['code']);
                if (!empty($userInfo['openid'])) {
                    $userInfo['openId']    = $userInfo['openid'];
                    $userInfo['nickName']  = '';//姓名
                    $userInfo['gender']    = '';//性别
                    $userInfo['language']  = '';//语言
                    $userInfo['city']      = '';//城市
                    $userInfo['province']  = '';//省份
                    $userInfo['country']   = '';//国家
                    $userInfo['avatarUrl'] = '';//头像
                    $userInfo['unionId']   = '';//用户在开放平台的唯一标识符
                    $userInfo['user_type'] = 'routine';//用户类型
                } else {
                    return app('json')->fail($userInfo);
                }
            }
            $userInfo = json_decode(json_encode($userInfo), true);
        }else {
            try {
                //解密获取用户信息
                $userInfo = MiniProgramService::encryptor($session_key, $data['iv'], $data['encryptedData']);
            } catch (\Exception $e) {
                if ($e->getCode() == '-41003') return app('json')->fail('获取会话密匙失败');
            }
        }

        $userInfo = json_decode(json_encode($userInfo), true);

        if (!isset($userInfo['openId'])) return app('json')->fail('openid获取失败!1');
        if (!isset($userInfo['unionId'])) $userInfo['unionId'] = '';
        $userInfo['spid']        = $data['spread_spid'];
        $userInfo['code']        = $data['spread_code'];
        $userInfo['session_key'] = $session_key;
        $userInfo['login_type']  = $data['login_type'];
        $uid                     = WechatUser::routineOauth($userInfo);
        $userInfo                = User::where('uid', $uid)->find();
        if ($userInfo->login_type == 'h5' && ($h5UserInfo = User::where(['account' => $userInfo->phone, 'phone' => $userInfo->phone, 'user_type' => 'h5'])->find()))
        $token = UserToken::createToken($userInfo, 'routine');
        else
        $token = UserToken::createToken($userInfo, 'routine');
        if ($token) {
            event('UserLogin', [$userInfo, $token]);
            return app('json')->successful('登陆成功！', [
                    'token'        => $token['token'],
                    'userInfo'     => $userInfo,
                    'expires_time' => strtotime($token['expires_time']),
                    'cache_key'    => $cache_key,
            ]);
        } else
            return app('json')->fail('获取用户访问token失败!');




        return ResultUtil.success();
    }
}
