package com.live.model;

import lombok.Data;

@Data
public class WxUserInfo {

    private String openId = "";
    private String nickName= "";
    private String gender = "";
    private String language = "";
    private String city = "";
    private String province = "";
    private String country = "";
    private String avatarUrl = "";
    private String unionId = "";
    private String user_type = "";

    private String spid ;
    private String code ;
    private String session_key ;
    private String login_type ;



}
