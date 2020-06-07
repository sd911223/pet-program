package com.pet.dao;

import com.pet.model.PetShop;
import com.pet.model.PetShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetShopMapper {
    long countByExample(PetShopExample example);

    int deleteByExample(PetShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PetShop record);

    int insertSelective(PetShop record);

    List<PetShop> selectByExample(PetShopExample example);

    PetShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PetShop record, @Param("example") PetShopExample example);

    int updateByExample(@Param("record") PetShop record, @Param("example") PetShopExample example);

    int updateByPrimaryKeySelective(PetShop record);

    int updateByPrimaryKey(PetShop record);
}