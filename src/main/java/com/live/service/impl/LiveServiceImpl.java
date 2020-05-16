package com.live.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live.common.RestResponse;
import com.live.model.LiveUser;
import com.live.service.LiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author shitou
 */
@Service
@Slf4j
public class LiveServiceImpl implements LiveService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public RestResponse getLiveList(Integer page, Integer store_id, String token) throws JsonProcessingException {
        //根据token获取uid
        String a = "njm_token_uid_eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9-eyJpc3MiOiJ5ZGNzLWFwcC1hcGkuMnYyLmNvIiwiYXVkIjoieWRjcy1hcHAtYXBpLjJ2Mi5jbyIsImlhdCI6MTU4OTU0NTU1MiwibmJmIjoxNTg5NTQ1NTUyLCJleHAiOjE1ODk1NTYzNTIsImp0aSI6eyJpZCI6NywidHlwZSI6InJvdXRpbmUifX0-zW60b1JpLRBQd-lmYAZqmwGZhe5PdQnLdEIL4HTGMpo:";
        Object o = redisTemplate.opsForValue().get(a);
//        String s1 = JSON.toJSONString(o);
        ObjectMapper objectMapper = new ObjectMapper();
        LiveUser liveUser = objectMapper.readValue(o.toString(), LiveUser.class);

//        LiveUser liveUserN = JSON.parseObject(s, LiveUser.class);
//        if (Objects.isNull(liveUser) || StringUtils.isEmpty(token)) {
//            throw new BusinessException("请登录", 410000);
//        }

//        LiveUser liveUser = JSONObject.parseObject(s, LiveUser.class);

        return null;
    }

}
