package com.sunjays.capl.dao;

import com.sunjays.capl.entity.CheckArea;
import com.sunjays.capl.entity.CheckAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckAreaMapper {
    int countByExample(CheckAreaExample example);

    int deleteByExample(CheckAreaExample example);

    int deleteByPrimaryKey(Integer wkid);

    int insert(CheckArea record);

    int insertSelective(CheckArea record);

    List<CheckArea> selectByExample(CheckAreaExample example);

    CheckArea selectByPrimaryKey(Integer wkid);

    int updateByExampleSelective(@Param("record") CheckArea record, @Param("example") CheckAreaExample example);

    int updateByExample(@Param("record") CheckArea record, @Param("example") CheckAreaExample example);

    int updateByPrimaryKeySelective(CheckArea record);

    int updateByPrimaryKey(CheckArea record);
}