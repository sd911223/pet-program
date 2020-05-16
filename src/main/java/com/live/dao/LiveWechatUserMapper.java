package com.live.dao;

import com.live.model.LiveWechatUser;
import com.live.model.LiveWechatUserExample;
import com.live.model.LiveWechatUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiveWechatUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int countByExample(LiveWechatUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int deleteByExample(LiveWechatUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(LiveWechatUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int insert(LiveWechatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int insertSelective(LiveWechatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    List<LiveWechatUser> selectByExample(LiveWechatUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    LiveWechatUser selectByPrimaryKey(LiveWechatUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LiveWechatUser record, @Param("example") LiveWechatUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LiveWechatUser record, @Param("example") LiveWechatUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LiveWechatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LiveWechatUser record);
}