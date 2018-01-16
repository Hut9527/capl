package com.sunjays.capl.dao;

import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserUnitMapper {
    int countByExample(UserUnitExample example);

    int deleteByExample(UserUnitExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(UserUnit record);

    int insertSelective(UserUnit record);

    List<UserUnit> selectByExample(UserUnitExample example);

    UserUnit selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") UserUnit record, @Param("example") UserUnitExample example);

    int updateByExample(@Param("record") UserUnit record, @Param("example") UserUnitExample example);

    int updateByPrimaryKeySelective(UserUnit record);

    int updateByPrimaryKey(UserUnit record);
}