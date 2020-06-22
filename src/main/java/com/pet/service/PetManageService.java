package com.pet.service;

import com.pet.bean.dto.PetInfoDto;
import com.pet.model.PetUser;

public interface PetManageService {
    Object savePetInfo(PetInfoDto petInfoDto, PetUser petUser);
}
