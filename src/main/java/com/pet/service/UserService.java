package com.pet.service;

import com.pet.bean.dto.req.LoginRqe;
import com.pet.model.PetUser;

public interface UserService {
    PetUser findByOpenid(String openid);

    Object login(LoginRqe loginRqe);

    PetUser findByUserId(Integer userId);
}
