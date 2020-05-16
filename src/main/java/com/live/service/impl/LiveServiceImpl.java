package com.live.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.model.LiveUser;
import com.live.service.IRedisService;
import com.live.service.LiveService;
import lombok.extern.slf4j.Slf4j;
import org.phprpc.util.AssocArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;

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
        String key = "njm_token_uid_eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9-eyJpc3MiOiJ5ZGNzLWFwcC1hcGkuMnYyLmNvIiwiYXVkIjoieWRjcy1hcHAtYXBpLjJ2Mi5jbyIsImlhdCI6MTU4OTU0NTU1MiwibmJmIjoxNTg5NTQ1NTUyLCJleHAiOjE1ODk1NTYzNTIsImp0aSI6eyJpZCI6NywidHlwZSI6InJvdXRpbmUifX0-zW60b1JpLRBQd-lmYAZqmwGZhe5PdQnLdEIL4HTGMpo:";
        Object value = redisService.get(key);
        LiveUser user = JSONObject.parseObject(value.toString(), LiveUser.class);
        return null;
    }

}
