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
        return null;
    }

}
