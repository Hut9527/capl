package com.sunjays.capl.dao;

import com.sunjays.capl.entity.ZoneInfo;
import com.sunjays.capl.entity.ZoneInfoExample;
import com.sunjays.capl.entity.ZoneVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneInfoMapper {
    int countByExample(ZoneInfoExample example);

    int deleteByExample(ZoneInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZoneInfo record);

    int insertSelective(ZoneInfo record);

    List<ZoneInfo> selectByExample(ZoneInfoExample example);

    ZoneInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZoneInfo record, @Param("example") ZoneInfoExample example);

    int updateByExample(@Param("record") ZoneInfo record, @Param("example") ZoneInfoExample example);

    int updateByPrimaryKeySelective(ZoneInfo record);

    int updateByPrimaryKey(ZoneInfo record);
    
    //查询全部信息
    List<ZoneVo> selectAll();
    
    //根据姓名查询活动区域
    ZoneInfo selectByName(String name);
    
    //根据车牌查询活动区域
    ZoneInfo selectByVehicle(String vehicle);
    
}