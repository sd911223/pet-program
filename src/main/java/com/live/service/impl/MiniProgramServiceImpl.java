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

        JSONObject paramJson = new JSONObject();
        paramJson.put("appid", companyId);
        paramJson.put("secret", sendSign);
        paramJson.put("js_code", sendSign);
        paramJson.put("grant_type", "authorization_code");

        'appid' => $this->config['app_id'],
                'secret' => $this->config['secret'],
                'js_code' => $jsCode,
                'grant_type' => 'authorization_code',


        HttpUtil http = new HttpUtil();
        String result = http.sendGetStream(JSCODE_TO_SESSION, donateJson.toJSONString(), "application/json");
        JSONObject obj = (JSONObject) JSONObject.parse(result);

        return null;
    }
}
