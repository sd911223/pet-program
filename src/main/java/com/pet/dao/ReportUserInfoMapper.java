package com.pet.dao;

import com.pet.model.ReportUserInfo;
import com.pet.model.ReportUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportUserInfoMapper {
    long countByExample(ReportUserInfoExample example);

    int deleteByExample(ReportUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportUserInfo record);

    int insertSelective(ReportUserInfo record);

    List<ReportUserInfo> selectByExample(ReportUserInfoExample example);

    ReportUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportUserInfo record, @Param("example") ReportUserInfoExample example);

    int updateByExample(@Param("record") ReportUserInfo record, @Param("example") ReportUserInfoExample example);

    int updateByPrimaryKeySelective(ReportUserInfo record);

    int updateByPrimaryKey(ReportUserInfo record);
}