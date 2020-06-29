package com.pet.controller;

import com.pet.annotation.LoginUser;
import com.pet.bean.dto.req.PetInfoRqe;
import com.pet.common.RestResponse;
import com.pet.common.ResultUtil;
import com.pet.model.PetUser;
import com.pet.service.PetManageService;
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
 * @Description 宠物管理
 * @Date 2020/6/22 18:22
 */
@Api(tags = "宠物管理")
@RestController
@RequestMapping("/petApi")
@Slf4j
public class PetManageController {
    @Autowired
    PetManageService petManageService;

    /**
     * 添加宠物信息
     */
    @PostMapping("/save/petInfo")
    @ApiOperation(value = "添加宠物信息")
    public RestResponse savePetInfo(@RequestBody @Valid PetInfoRqe petInfoRqe, @LoginUser PetUser petUser) {

        return ResultUtil.success(petManageService.savePetInfo(petInfoRqe, petUser));

    }

    /**
     * 获取宠物信息
     *
     * @param petUser
     * @return
     */
    @PostMapping("/get/petInfo")
    @ApiOperation(value = "添加宠物信息")
    public RestResponse getPetInfo(@LoginUser PetUser petUser) {
        return null;
    }
}
