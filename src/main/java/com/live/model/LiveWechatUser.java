package com.live.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LiveWechatUser extends LiveWechatUserKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.unionid
     *
     * @mbggenerated
     */
    private String unionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.openid
     *
     * @mbggenerated
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.headimgurl
     *
     * @mbggenerated
     */
    private String headimgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.sex
     *
     * @mbggenerated
     */
    private Boolean sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.city
     *
     * @mbggenerated
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.language
     *
     * @mbggenerated
     */
    private String language;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.province
     *
     * @mbggenerated
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.country
     *
     * @mbggenerated
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.groupid
     *
     * @mbggenerated
     */
    private Short groupid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.tagid_list
     *
     * @mbggenerated
     */
    private String tagid_list;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.subscribe
     *
     * @mbggenerated
     */
    private Byte subscribe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.subscribe_time
     *
     * @mbggenerated
     */
    private Integer subscribe_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.add_time
     *
     * @mbggenerated
     */
    private Integer add_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.stair
     *
     * @mbggenerated
     */
    private Integer stair;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.second
     *
     * @mbggenerated
     */
    private Integer second;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.order_stair
     *
     * @mbggenerated
     */
    private Integer order_stair;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.order_second
     *
     * @mbggenerated
     */
    private Integer order_second;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.now_money
     *
     * @mbggenerated
     */
    private BigDecimal now_money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.session_key
     *
     * @mbggenerated
     */
    private String session_key;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_wechat_user.user_type
     *
     * @mbggenerated
     */
    private String user_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.unionid
     *
     * @return the value of live_wechat_user.unionid
     *
     * @mbggenerated
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.unionid
     *
     * @param unionid the value for live_wechat_user.unionid
     *
     * @mbggenerated
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.openid
     *
     * @return the value of live_wechat_user.openid
     *
     * @mbggenerated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.openid
     *
     * @param openid the value for live_wechat_user.openid
     *
     * @mbggenerated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.nickname
     *
     * @return the value of live_wechat_user.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.nickname
     *
     * @param nickname the value for live_wechat_user.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.headimgurl
     *
     * @return the value of live_wechat_user.headimgurl
     *
     * @mbggenerated
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.headimgurl
     *
     * @param headimgurl the value for live_wechat_user.headimgurl
     *
     * @mbggenerated
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.sex
     *
     * @return the value of live_wechat_user.sex
     *
     * @mbggenerated
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.sex
     *
     * @param sex the value for live_wechat_user.sex
     *
     * @mbggenerated
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.city
     *
     * @return the value of live_wechat_user.city
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.city
     *
     * @param city the value for live_wechat_user.city
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.language
     *
     * @return the value of live_wechat_user.language
     *
     * @mbggenerated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.language
     *
     * @param language the value for live_wechat_user.language
     *
     * @mbggenerated
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.province
     *
     * @return the value of live_wechat_user.province
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.province
     *
     * @param province the value for live_wechat_user.province
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.country
     *
     * @return the value of live_wechat_user.country
     *
     * @mbggenerated
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.country
     *
     * @param country the value for live_wechat_user.country
     *
     * @mbggenerated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.remark
     *
     * @return the value of live_wechat_user.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.remark
     *
     * @param remark the value for live_wechat_user.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.groupid
     *
     * @return the value of live_wechat_user.groupid
     *
     * @mbggenerated
     */
    public Short getGroupid() {
        return groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.groupid
     *
     * @param groupid the value for live_wechat_user.groupid
     *
     * @mbggenerated
     */
    public void setGroupid(Short groupid) {
        this.groupid = groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.tagid_list
     *
     * @return the value of live_wechat_user.tagid_list
     *
     * @mbggenerated
     */
    public String getTagid_list() {
        return tagid_list;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.tagid_list
     *
     * @param tagid_list the value for live_wechat_user.tagid_list
     *
     * @mbggenerated
     */
    public void setTagid_list(String tagid_list) {
        this.tagid_list = tagid_list == null ? null : tagid_list.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.subscribe
     *
     * @return the value of live_wechat_user.subscribe
     *
     * @mbggenerated
     */
    public Byte getSubscribe() {
        return subscribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.subscribe
     *
     * @param subscribe the value for live_wechat_user.subscribe
     *
     * @mbggenerated
     */
    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.subscribe_time
     *
     * @return the value of live_wechat_user.subscribe_time
     *
     * @mbggenerated
     */
    public Integer getSubscribe_time() {
        return subscribe_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.subscribe_time
     *
     * @param subscribe_time the value for live_wechat_user.subscribe_time
     *
     * @mbggenerated
     */
    public void setSubscribe_time(Integer subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.add_time
     *
     * @return the value of live_wechat_user.add_time
     *
     * @mbggenerated
     */
    public Integer getAdd_time() {
        return add_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.add_time
     *
     * @param add_time the value for live_wechat_user.add_time
     *
     * @mbggenerated
     */
    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.stair
     *
     * @return the value of live_wechat_user.stair
     *
     * @mbggenerated
     */
    public Integer getStair() {
        return stair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.stair
     *
     * @param stair the value for live_wechat_user.stair
     *
     * @mbggenerated
     */
    public void setStair(Integer stair) {
        this.stair = stair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.second
     *
     * @return the value of live_wechat_user.second
     *
     * @mbggenerated
     */
    public Integer getSecond() {
        return second;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.second
     *
     * @param second the value for live_wechat_user.second
     *
     * @mbggenerated
     */
    public void setSecond(Integer second) {
        this.second = second;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.order_stair
     *
     * @return the value of live_wechat_user.order_stair
     *
     * @mbggenerated
     */
    public Integer getOrder_stair() {
        return order_stair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.order_stair
     *
     * @param order_stair the value for live_wechat_user.order_stair
     *
     * @mbggenerated
     */
    public void setOrder_stair(Integer order_stair) {
        this.order_stair = order_stair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.order_second
     *
     * @return the value of live_wechat_user.order_second
     *
     * @mbggenerated
     */
    public Integer getOrder_second() {
        return order_second;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.order_second
     *
     * @param order_second the value for live_wechat_user.order_second
     *
     * @mbggenerated
     */
    public void setOrder_second(Integer order_second) {
        this.order_second = order_second;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.now_money
     *
     * @return the value of live_wechat_user.now_money
     *
     * @mbggenerated
     */
    public BigDecimal getNow_money() {
        return now_money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.now_money
     *
     * @param now_money the value for live_wechat_user.now_money
     *
     * @mbggenerated
     */
    public void setNow_money(BigDecimal now_money) {
        this.now_money = now_money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.session_key
     *
     * @return the value of live_wechat_user.session_key
     *
     * @mbggenerated
     */
    public String getSession_key() {
        return session_key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.session_key
     *
     * @param session_key the value for live_wechat_user.session_key
     *
     * @mbggenerated
     */
    public void setSession_key(String session_key) {
        this.session_key = session_key == null ? null : session_key.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_wechat_user.user_type
     *
     * @return the value of live_wechat_user.user_type
     *
     * @mbggenerated
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_wechat_user.user_type
     *
     * @param user_type the value for live_wechat_user.user_type
     *
     * @mbggenerated
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type == null ? null : user_type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_wechat_user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", unionid=").append(unionid);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", sex=").append(sex);
        sb.append(", city=").append(city);
        sb.append(", language=").append(language);
        sb.append(", province=").append(province);
        sb.append(", country=").append(country);
        sb.append(", remark=").append(remark);
        sb.append(", groupid=").append(groupid);
        sb.append(", tagid_list=").append(tagid_list);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", subscribe_time=").append(subscribe_time);
        sb.append(", add_time=").append(add_time);
        sb.append(", stair=").append(stair);
        sb.append(", second=").append(second);
        sb.append(", order_stair=").append(order_stair);
        sb.append(", order_second=").append(order_second);
        sb.append(", now_money=").append(now_money);
        sb.append(", session_key=").append(session_key);
        sb.append(", user_type=").append(user_type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}