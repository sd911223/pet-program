package com.live.controller;

import com.live.common.RestResponse;
import com.live.common.ResultUtil;
import io.swagger.annotations.Api;
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
    public RestResponse mp_auth() {
        return ResultUtil.success();
    }
}
