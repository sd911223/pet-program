package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.exception.BusinessException;
import com.live.model.LiveUser;
import com.live.service.LiveService;
import com.live.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author shitou
 */
@Service
public class LiveServiceImpl implements LiveService {
    @Override
    public RestResponse getLiveList(Integer page, Integer store_id, String token) {
        //根据token获取uid
        Object user = new RedisUtil().get("redis.user_token_pre" + token + ":");

        if (Objects.isNull(user) || StringUtils.isEmpty(token)) {
            throw new BusinessException("请登录", 410000);
        }

        LiveUser liveUser = JSONObject.parseObject(JSONObject.toJSONString(user), LiveUser.class);

        return null;
    }
}
