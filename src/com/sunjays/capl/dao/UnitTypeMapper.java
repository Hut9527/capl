package com.sunjays.capl.dao;

import com.sunjays.capl.entity.UnitType;
import com.sunjays.capl.entity.UnitTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitTypeMapper {
    int countByExample(UnitTypeExample example);

    int deleteByExample(UnitTypeExample example);

    int deleteByPrimaryKey(Integer utid);

    int insert(UnitType record);

    int insertSelective(UnitType record);

    List<UnitType> selectByExample(UnitTypeExample example);

    UnitType selectByPrimaryKey(Integer utid);

    int updateByExampleSelective(@Param("record") UnitType record, @Param("example") UnitTypeExample example);

    int updateByExample(@Param("record") UnitType record, @Param("example") UnitTypeExample example);

    int updateByPrimaryKeySelective(UnitType record);

    int updateByPrimaryKey(UnitType record);
}