package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.common.RestResponse;
import com.live.dao.LiveStoreClerkMapper;
import com.live.dao.LiveStoreMapper;
import com.live.dao.LiveUserMapper;
import com.live.model.LiveStore;
import com.live.model.LiveStoreClerk;
import com.live.model.LiveStoreKey;
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
    @Autowired
    LiveUserMapper liveUserMapper;
    @Autowired
    LiveStoreClerkMapper liveStoreClerkMapper;
    @Autowired
    LiveStoreMapper liveStoreMapper;

    @Override
    public RestResponse getLiveList(Integer page, Integer store_id, String lng, String lat, String cityCode, String token) {
        //根据token获取uid
        Object value = redisService.getToken(token);
        LiveUser user = JSONObject.parseObject(value.toString(), LiveUser.class);
        LiveUser liveUser = liveUserMapper.selectByPrimaryKey(user.getUid());
        LiveStore liveStore = null;
        Integer storeId = null;
        if (liveUser.getClerk_id() != null) {
            liveStore = getLiveStore(liveUser.getClerk_id());
            if (liveStore != null) {
                storeId=liveStore.getId();
            }
        }
        return null;
    }

    /**
     * 获取绑定店铺
     *
     * @param clerkId
     * @return
     */
    public LiveStore getLiveStore(Integer clerkId) {
        LiveStoreClerk clerk = liveStoreClerkMapper.selectByPrimaryKey(clerkId);
        if (clerk.getStore_id() == null || clerk == null) {
            return new LiveStore();
        }
        LiveStoreKey liveStoreKey = new LiveStoreKey();
        if (clerk.getStore_id() == null) {
            return new LiveStore();
        }
        liveStoreKey.setStore_no(clerk.getStore_id().toString());
        LiveStore liveStore = liveStoreMapper.selectByPrimaryKey(liveStoreKey);

        return liveStore;
    }
}
