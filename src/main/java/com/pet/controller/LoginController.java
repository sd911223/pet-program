package com.pet.controller;

import com.alibaba.fastjson.JSON;
import com.pet.annotation.LoginUser;
import com.pet.bean.dto.LoginDto;
import com.pet.common.RestResponse;
import com.pet.common.ResultUtil;
import com.pet.model.PetUser;
import com.pet.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Api(tags = "登录")
@RestController
@RequestMapping("/petApi")
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;

    /**
     * 登陆接口
     */
    @PostMapping("/weChat/login")
    @ApiOperation(value = "小程序登录")
    public RestResponse<Map> login(@RequestBody @Valid LoginDto loginDto) {

        return ResultUtil.success(userService.login(loginDto));

    }

    @PostMapping("/weChat/test")
    @ApiOperation(value = "测试注解")
    public RestResponse<PetUser> testToken(@LoginUser PetUser petUser) {
        log.info(JSON.toJSONString(petUser));
        return null;

    }


}
