package com.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.live.dao.LiveRoutineQrcodeMapper;
import com.live.dao.LiveSystemConfigMapper;
import com.live.dao.LiveUserMapper;
import com.live.dao.LiveWechatUserMapper;
import com.live.model.*;
import com.live.service.MiniProgramService;
import com.live.service.WechatUserInterface;
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
public class WechatUserServiceImpl implements WechatUserInterface {

    @Autowired
    private LiveRoutineQrcodeMapper liveRoutineQrcodeMapper;
    @Autowired
    private LiveWechatUserMapper liveWechatUserMapper;
    @Autowired
    private LiveUserMapper liveUserMapper;


    @Override
    public LiveUser routineOauth(WxUserInfo wxUserInfo) {

       // build LiveWechatUser
        LiveWechatUser liveWechatUser = new LiveWechatUser();
        liveWechatUser.setNickname(wxUserInfo.getNickName());
        //liveWechatUser.setSex(Integer.valueOf(wxUserInfo.getGender()));
        liveWechatUser.setLanguage(wxUserInfo.getLanguage());
        liveWechatUser.setCity(wxUserInfo.getCity());
        liveWechatUser.setProvince(wxUserInfo.getProvince());
        liveWechatUser.setCountry(wxUserInfo.getCountry());
        liveWechatUser.setHeadimgurl(wxUserInfo.getAvatarUrl());
        liveWechatUser.setRoutine_openid(wxUserInfo.getOpenId());
        liveWechatUser.setSession_key(wxUserInfo.getSession_key());
        liveWechatUser.setUnionid(wxUserInfo.getUnionId());
        liveWechatUser.setUser_type(wxUserInfo.getUser_type());

        int spid = 0;//绑定关系uid
        boolean isCode = false;

        //获取是否有扫码进小程序
        if(StringUtil.isNotNull(wxUserInfo.getCode())){
            LiveRoutineQrcodeExample example = new LiveRoutineQrcodeExample();
            example.createCriteria().andIdEqualTo(Integer.valueOf(wxUserInfo.getCode())).andStatusEqualTo(1);
            List<LiveRoutineQrcode> qrcodeList = liveRoutineQrcodeMapper.selectByExample(example);

            if(qrcodeList != null && qrcodeList.size() > 0){
                spid = qrcodeList.get(0).getThird_id();
                isCode=true;
            }else{
                spid = Integer.valueOf(wxUserInfo.getSpid());
            }
        }else if(StringUtil.isNotNull(wxUserInfo.getSpid())) {
            spid = Integer.valueOf(wxUserInfo.getSpid());
        }

        //  判断unionid  存在根据unionid判断
        LiveWechatUserExample liveWechatUserExample = new LiveWechatUserExample();
        liveWechatUserExample.createCriteria().andUnionidEqualTo(wxUserInfo.getUnionId());
        List<LiveWechatUser> wechatUserList = liveWechatUserMapper.selectByExample(liveWechatUserExample);
        Integer uid = null;
        if(wechatUserList != null && wechatUserList.size() > 0) {
            uid = wechatUserList.get(0).getUid();
        }

        if(uid == null) {
            liveWechatUserExample = new LiveWechatUserExample();
            liveWechatUserExample.createCriteria().andRoutine_openidEqualTo(liveWechatUser.getRoutine_openid());
             wechatUserList = liveWechatUserMapper.selectByExample(liveWechatUserExample);
            if(wechatUserList != null && wechatUserList.size() > 0) {
                uid = wechatUserList.get(0).getUid();
            }
        }

        if(uid != null){
            liveWechatUserMapper.updateByExampleSelective(liveWechatUser, liveWechatUserExample);
            updateWechatUser(liveWechatUser, wxUserInfo, uid);

        }else{

           // liveWechatUser.setAdd_time();
            // $routineInfo['bind_store_time'] = time();//用户添加时间
            // liveWechatUser.setb

            liveWechatUserMapper.insertSelective(liveWechatUser);

            LiveUser liveUser = new LiveUser();
            liveUser.setAccount("rt"+liveWechatUser.getUid()+System.currentTimeMillis());
            liveUser.setPwd(MD5Util.toMd5("123456"));
            liveUser.setNickname(liveWechatUser.getNickname());
            liveUser.setAvatar(liveWechatUser.getHeadimgurl());
            liveUser.setSpread_uid(spid);
            liveUser.setSpread_time(spid > 0 ? (int)System.currentTimeMillis():0);
            liveUser.setUid(liveWechatUser.getUid());
            liveUser.setAdd_time(liveWechatUser.getAdd_time());
            //liveUser.setAdd_ip();
            liveUser.setLast_time((int)System.currentTimeMillis());
            //liveUser.setLast_ip();
            liveUser.setUser_type(liveWechatUser.getUser_type());

            liveUserMapper.insertSelective(liveUser);
            uid = liveUser.getUid();
        }

        return null;
    }

    private void updateWechatUser(LiveWechatUser liveWechatUser,WxUserInfo wxUserInfo,Integer uid) {
        LiveUser liveUser = liveUserMapper.selectByPrimaryKey(uid);
        if(StringUtil.isNotNull(wxUserInfo.getLogin_type())) {
            liveUser.setLogin_type(wxUserInfo.getLogin_type());
        }
        liveUser.setNickname(liveWechatUser.getNickname());
        liveUser.setAvatar(liveWechatUser.getHeadimgurl());

        if(liveUser.getSpread_uid() != null && liveUser.getSpread_uid() > 0){
            liveUserMapper.updateByPrimaryKeySelective(liveUser);
        }else {

            //liveUser.setIs_promoter();
            liveUser.setLast_time((int)System.currentTimeMillis());

            // TODO
            // liveUser.setSpread_uid();
            // liveUser.setSpread_time();
            //liveUser.setLast_ip();
            liveUserMapper.updateByPrimaryKeySelective(liveUser);

        }

    }
}
