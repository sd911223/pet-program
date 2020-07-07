package com.pet.service;

import com.pet.bean.dto.req.LoginRqe;
import com.pet.bean.dto.req.ReportReq;
import com.pet.common.RestResponse;
import com.pet.model.PetUser;

public interface UserService {
    PetUser findByOpenid(String openid);

    RestResponse<String> login(LoginRqe loginRqe);

    PetUser findByUserId(Integer userId);

    RestResponse report(ReportReq reportReq);
}
