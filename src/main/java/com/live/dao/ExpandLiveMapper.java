package com.live.dao;

import com.live.model.DO.LiveStoreDO;
import com.live.model.LiveStore;

/**
 * @author shitou
 */
public interface ExpandLiveMapper {
    LiveStore getBindStore(Integer uid);
}
