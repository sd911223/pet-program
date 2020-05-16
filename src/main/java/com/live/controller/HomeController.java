package com.live.controller;

import com.live.common.RestResponse;
import com.live.common.ResultUtil;
import com.live.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shitou
 */
@RestController
@Api(tags = "首页")
@RequestMapping("/api")
@Slf4j
public class HomeController {
    @Autowired
    HomeService homeService;

    @ApiOperation("新版首页")
    @GetMapping("/index")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hotProduct", example = "16"),
            @ApiImplicitParam(name = "recommendProduct", example = "3"),
            @ApiImplicitParam(name = "goodProduct", example = "4,5"),
            @ApiImplicitParam(name = "newProduct", example = "1,3,5"),
            @ApiImplicitParam(name = "storeId", example = ""),
            @ApiImplicitParam(name = "type", example = "0")
    })
    public RestResponse indexMap(String hotProduct, String recommendProduct, String goodProduct, String newProduct, String storeId, String type, @RequestHeader(value = "Authori-zation", defaultValue = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9-eyJpc3MiOiJ5ZGNzLWFwcC1hcGkuMnYyLmNvIiwiYXVkIjoieWRjcy1hcHAtYXBpLjJ2Mi5jbyIsImlhdCI6MTU4OTU0NTU1MiwibmJmIjoxNTg5NTQ1NTUyLCJleHAiOjE1ODk1NTYzNTIsImp0aSI6eyJpZCI6NywidHlwZSI6InJvdXRpbmUifX0-zW60b1JpLRBQd-lmYAZqmwGZhe5PdQnLdEIL4HTGMpo") String token) {
        log.info("进入首页->新版首页->url->{},hotProduct->{},recommendProduct->{},goodProduct->{},newProduct->{},storeId->{},type->{}", hotProduct, recommendProduct, goodProduct, newProduct, storeId, type);


        return homeService.indexMap(hotProduct,recommendProduct,goodProduct,newProduct,storeId,type);
    }
}
