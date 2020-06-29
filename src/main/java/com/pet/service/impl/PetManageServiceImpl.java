package com.pet.service.impl;

import com.pet.bean.dto.req.PetInfoRqe;
import com.pet.common.ResultUtil;
import com.pet.dao.PetInfoMapper;
import com.pet.model.PetInfo;
import com.pet.model.PetUser;
import com.pet.service.PetManageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author dun.shi
 */
@Service
public class PetManageServiceImpl implements PetManageService {
    @Autowired
    PetInfoMapper petInfoMapper;

    @Override
    public Object savePetInfo(PetInfoRqe petInfoRqe, PetUser petUser) {
        PetInfo petInfo = new PetInfo();
        BeanUtils.copyProperties(petInfoRqe, petInfo);
        petInfo.setUserId(petUser.getId());
        petInfo.setCreateTime(new Date());
        petInfoMapper.insert(petInfo);
        return ResultUtil.success("添加成功!");
    }
}
