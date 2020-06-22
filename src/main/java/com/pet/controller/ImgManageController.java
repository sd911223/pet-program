package com.pet.controller;

import com.pet.common.RestResponse;
import com.pet.service.ImgUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shitou
 * @Description 图片管理
 * @Date 2020/6/22 18:07
 */
@RestController
@RequestMapping(value = "/petApi")
@Api(tags = "图片管理")
public class ImgManageController {
    @Autowired
    ImgUploadService imgUploadService;

    @PostMapping("/upload")
    @ApiOperation("上传")
    public RestResponse uploadFile(@RequestParam("file") MultipartFile file) {

        return imgUploadService.upload(file);
    }
}
