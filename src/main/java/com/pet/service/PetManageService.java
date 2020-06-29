package com.pet.service;

import com.pet.bean.dto.req.PetInfoRqe;
import com.pet.model.PetUser;

public interface PetManageService {
    Object savePetInfo(PetInfoRqe petInfoRqe, PetUser petUser);
}
