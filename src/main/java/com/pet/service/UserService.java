package com.pet.service;

import com.pet.bean.dto.LoginDto;
import com.pet.model.PetUser;

public interface UserService {
    PetUser findByOpenid(String openid);

    Object login(LoginDto loginDto);
}
