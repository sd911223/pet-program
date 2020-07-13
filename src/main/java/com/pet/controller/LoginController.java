package com.pet.controller;

import com.alibaba.fastjson.JSON;
import com.pet.annotation.LoginUser;
import com.pet.bean.dto.req.LoginRqe;
import com.pet.bean.dto.req.ReportReq;
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

/**
 * @author dun.shi
 * @Description TODO
 * @Date 2020/6/22 18:07
 */
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
    public RestResponse<String> login(@RequestBody @Valid LoginRqe loginRqe) {

        return ResultUtil.success(userService.login(loginRqe));

    }

    @PostMapping("/weChat/report")
    @ApiOperation(value = "上报")
    public RestResponse report(@RequestBody @Valid ReportReq reportReq) {
        return userService.report(reportReq);

    }


}
