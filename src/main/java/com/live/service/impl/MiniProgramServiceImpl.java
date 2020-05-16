package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.model.LiveUser;
import com.live.service.IRedisService;
import com.live.service.LiveService;
import com.live.service.MiniProgramService;
import com.live.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shitou
 */
@Service
@Slf4j
public class MiniProgramServiceImpl implements MiniProgramService {

    private final static String JSCODE_TO_SESSION = "https://api.weixin.qq.com/sns/jscode2session";


    @Override
    public JSONObject getUserInfo() {

        return null;
    }
}
