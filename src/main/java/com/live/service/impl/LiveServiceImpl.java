package com.live.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live.common.RestResponse;
import com.live.exception.BusinessException;
import com.live.model.LiveUser;
import com.live.service.LiveService;
import com.live.util.JsonUtils;
import com.live.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author shitou
 */
@Service
@Slf4j
public class LiveServiceImpl implements LiveService {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public RestResponse getLiveList(Integer page, Integer store_id, String token) throws JsonProcessingException {
        //根据token获取uid
        String a = "njm_token_uid_eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9-eyJpc3MiOiJ5ZGNzLWFwcC1hcGkuMnYyLmNvIiwiYXVkIjoieWRjcy1hcHAtYXBpLjJ2Mi5jbyIsImlhdCI6MTU4OTU0NTU1MiwibmJmIjoxNTg5NTQ1NTUyLCJleHAiOjE1ODk1NTYzNTIsImp0aSI6eyJpZCI6NywidHlwZSI6InJvdXRpbmUifX0-zW60b1JpLRBQd-lmYAZqmwGZhe5PdQnLdEIL4HTGMpo:";
        Object o = redisUtil.get(a);
        String s = redisTemplate.opsForValue().get(a);

        log.info(s);
        log.info(o.toString());
        String toJson = JsonUtils.objectToJson(o);
        LiveUser user=JsonUtils.jsonToPojo(toJson,LiveUser.class);
        if (Objects.isNull(user) || StringUtils.isEmpty(token)) {
            throw new BusinessException("请登录", 410000);
        }

//        LiveUser liveUser = JSONObject.parseObject(s, LiveUser.class);

        return null;
    }
}
