package com.pet.dao;

import com.pet.model.PetInfo;
import com.pet.model.PetInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetInfoMapper {
    long countByExample(PetInfoExample example);

    int deleteByExample(PetInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PetInfo record);

    int insertSelective(PetInfo record);

    List<PetInfo> selectByExample(PetInfoExample example);

    PetInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PetInfo record, @Param("example") PetInfoExample example);

    int updateByExample(@Param("record") PetInfo record, @Param("example") PetInfoExample example);

    int updateByPrimaryKeySelective(PetInfo record);

    int updateByPrimaryKey(PetInfo record);
}