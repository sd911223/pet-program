package com.pet.dao;

import com.pet.model.PetUser;
import com.pet.model.PetUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetUserMapper {
    long countByExample(PetUserExample example);

    int deleteByExample(PetUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PetUser record);

    int insertSelective(PetUser record);

    List<PetUser> selectByExample(PetUserExample example);

    PetUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PetUser record, @Param("example") PetUserExample example);

    int updateByExample(@Param("record") PetUser record, @Param("example") PetUserExample example);

    int updateByPrimaryKeySelective(PetUser record);

    int updateByPrimaryKey(PetUser record);
}