package com.sunjays.capl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunjays.capl.entity.ZoneName;
import com.sunjays.capl.entity.ZoneNameExample;

public interface ZoneNameService {
	
    int countByExample(ZoneNameExample example);

    int deleteByExample(ZoneNameExample example);

    int deleteByPrimaryKey(Integer wkid);

    int insert(ZoneName record);

    int insertSelective(ZoneName record);

    List<ZoneName> selectByExample(ZoneNameExample example);

    ZoneName selectByPrimaryKey(Integer wkid);

    int updateByExampleSelective(@Param("record") ZoneName record, @Param("example") ZoneNameExample example);

    int updateByExample(@Param("record") ZoneName record, @Param("example") ZoneNameExample example);

    int updateByPrimaryKeySelective(ZoneName record);

    int updateByPrimaryKey(ZoneName record);

}
