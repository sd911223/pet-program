package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.dao.LiveSystemConfigMapper;
import com.live.model.LiveSystemConfig;
import com.live.model.LiveSystemConfigExample;
import com.live.model.LiveUser;
import com.live.service.IRedisService;
import com.live.service.LiveService;
import com.live.service.MiniProgramService;
import com.live.util.HttpUtil;
import com.live.util.MD5Util;
import com.live.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shitou
 */
@Service
@Slf4j
public class MiniProgramServiceImpl implements MiniProgramService {

    private final static String JSCODE_TO_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
    @Autowired
    private LiveSystemConfigMapper liveSystemConfigMapper;
    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    private static Map<String,String> configMap = new HashMap<>();

    {
        if(configMap.size() <= 0) {
            LiveSystemConfigExample example = new LiveSystemConfigExample();
            List<LiveSystemConfig> liveSystemConfigList = liveSystemConfigMapper.selectByExample(example);
            liveSystemConfigList.forEach(liveSystemConfig -> {
                configMap.put(liveSystemConfig.getMenu_name(), liveSystemConfig.getValue());
            });
        }
    }


    @Override
    public JSONObject getUserInfo(String code) {

        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid", configMap.get("wechat_appid"));
        paramMap.put("secret", configMap.get("wechat_appsecret"));
        paramMap.put("js_code", code);
        paramMap.put("grant_type", "authorization_code");

        HttpUtil http = new HttpUtil();
        String result = http.sendGetStream(JSCODE_TO_SESSION, StringUtil.getUrlStr(paramMap));
        JSONObject obj = (JSONObject) JSONObject.parse(result);

        return obj;
    }

    @Override
    public JSONObject notPowerOpenid(String code) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid", configMap.get("routine_appId"));
        paramMap.put("secret", configMap.get("routine_appsecret"));
        paramMap.put("js_code", code);
        paramMap.put("grant_type", "authorization_code");

        HttpUtil http = new HttpUtil();
        String result = http.sendGetStream(JSCODE_TO_SESSION, StringUtil.getUrlStr(paramMap));
        JSONObject obj = (JSONObject) JSONObject.parse(result);

        // 判断sessionKey不为空则加入缓存
        if (obj.containsKey("session_key")) {
            String sessionKey = obj.getString("session_key");
            String cacheKey  =  MD5Util.toMd5(code);
            // 加入缓存
            Element element = new Element("api_code:"+cacheKey, sessionKey);
            ehCacheCacheManager.getCacheManager().getCache("myCache").put(element);
            return obj;
        } else {
            return obj;
        }

    }
}
