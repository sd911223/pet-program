package com.live.service;

import com.live.model.LiveUser;
import com.live.model.WxUserInfo;

public interface WechatUserInterface {

    LiveUser routineOauth(WxUserInfo wxUserInfo);
}
