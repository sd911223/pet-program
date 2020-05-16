package com.live.controller;

import com.github.pagehelper.PageInfo;
import com.live.common.RestResponse;
import com.live.model.LiveActivity;
import com.live.service.LiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shitou
 */
@RestController
@Api(tags = "live")
@RequestMapping("/api/store")
public class LiveController {
    @Autowired
    LiveService liveService;

    @ApiOperation("获取列表")
    @GetMapping("/live_list")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", required = true, example = "1"),
            @ApiImplicitParam(value = "store_id", required = false, example = ""),
            @ApiImplicitParam(value = "lng", required = false, example = ""),
            @ApiImplicitParam(value = "lat", required = false, example = ""),
            @ApiImplicitParam(value = "cityCode", required = false, example = "")
    })
    public RestResponse<PageInfo<LiveActivity>> getLiveList(Integer page, Integer store_id, String lng, String lat, String cityCode, @RequestHeader("Authorization") String token) {
        return liveService.getLiveList(page, store_id, lng, lat, cityCode, token);
    }
}
