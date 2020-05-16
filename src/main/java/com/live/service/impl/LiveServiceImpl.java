package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.model.LiveUser;
import com.live.service.IRedisService;
import com.live.service.LiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shitou
 */
@Service
@Slf4j
public class LiveServiceImpl implements LiveService {
    @Autowired
    private IRedisService redisService;

    @Override
    public RestResponse getLiveList(Integer page, Integer store_id, String token) {
        //根据token获取uid
        Object value = redisService.getToken(token);
        LiveUser user = JSONObject.parseObject(value.toString(), LiveUser.class);
        return null;
    }

}
