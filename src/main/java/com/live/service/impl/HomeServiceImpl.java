package com.live.service.impl;

import com.alibaba.fastjson.JSON;
import com.live.common.RestResponse;
import com.live.dao.LiveActivityExcludeMapper;
import com.live.dao.LiveActivityMapper;
import com.live.dao.LiveStoreTreeMapper;
import com.live.model.*;
import com.live.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shitou
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    LiveActivityMapper liveActivityMapper;
    @Autowired
    LiveStoreTreeMapper liveStoreTreeMapper;
    @Autowired
    LiveActivityExcludeMapper liveActivityExcludeMapper;

    @Override
    public RestResponse indexMap(String hotProduct, String recommendProduct, String goodProduct, String newProduct, String storeId, String type) {
        //查出直播海报
        List<LiveActivity> listActivity = getListActivity(storeId);
        if (!listActivity.isEmpty()) {
            for (LiveActivity liveActivity : listActivity) {
                String store_id_json = liveActivity.getStore_id_json();
                List<String> lists = JSON.parseArray(store_id_json, String.class);
                // 判断是否设置参与活动门店，有设置，看看门店是否被选中
                if (!lists.isEmpty()) {
                    for (String e : lists) {
                        //所有门店ID
                        List<Integer> listStoreId = getListStoreId(e);
                        LiveActivityExcludeExample excludeExample = new LiveActivityExcludeExample();
                        excludeExample.createCriteria().andStore_idIn(listStoreId);
                        int count = liveActivityExcludeMapper.countByExample(excludeExample);
                        if (count > 0) {
                            break;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 查询上级ID
     *
     * @param storeId
     * @return
     */
    public List<Integer> getListStoreId(String storeId) {
        List<Integer> list = new ArrayList<>();
        LiveStoreTreeExample storeTreeExample = new LiveStoreTreeExample();
        storeTreeExample.createCriteria().andStore_idEqualTo(Integer.valueOf(storeId));
        List<LiveStoreTree> storeTreeList = liveStoreTreeMapper.selectByExample(storeTreeExample);
        if (!storeTreeList.isEmpty()) {
            if (storeTreeList.get(0).getStore_pid() == 0) {
                list.add(Integer.valueOf(storeId));
                return list;
            } else {
                while (true) {
                    storeTreeExample.createCriteria().andStore_idEqualTo(storeTreeList.get(0).getStore_id());
                    List<LiveStoreTree> storeTrees = liveStoreTreeMapper.selectByExample(storeTreeExample);
                    if (storeTrees.get(0).getStore_pid() == 0) {
                        break;
                    } else {
                        list.add(storeTrees.get(0).getStore_pid());
                    }

                }
            }
        }
        return list;
    }

    /**
     * 查询直播海报
     *
     * @param storeId
     * @return
     */
    public List<LiveActivity> getListActivity(String storeId) {
        LiveActivityExample activityExample = new LiveActivityExample();
        activityExample.createCriteria().
                andIs_showEqualTo(2).
                andIs_delEqualTo(2).
                andActivity_statusLessThan(4);
        activityExample.setOrderByClause("sort desc, start_time asc");
        return liveActivityMapper.selectByExample(activityExample);
    }
}
