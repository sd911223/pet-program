package com.live.dao;

import com.live.model.LiveStore;
import org.apache.ibatis.annotations.Select;

public interface ExpandLiveMapper {
    @Select("select \n" +
            "  * \n" +
            "from\n" +
            "  live_user u,\n" +
            "  live_store_clerk c,\n" +
            "  live_store s \n" +
            "where u.clerk_id = c.id \n" +
            "  and c.store_id = s.id \n" +
            "  and u.uid=#{uid}")
    LiveStore getBindStore(Integer uid);
}
