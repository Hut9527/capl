package com.sunjays.capl.dao;

import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleInfoMapper {
    int countByExample(VehicleInfoExample example);

    int deleteByExample(VehicleInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleInfo record);

    int insertSelective(VehicleInfo record);

    List<VehicleInfo> selectByExample(VehicleInfoExample example);

    VehicleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleInfo record, @Param("example") VehicleInfoExample example);

    int updateByExample(@Param("record") VehicleInfo record, @Param("example") VehicleInfoExample example);

    int updateByPrimaryKeySelective(VehicleInfo record);

    int updateByPrimaryKey(VehicleInfo record);
  //查询所有车辆信息录入情况
    List<VehicleInfo> selectAll();
    
    //查询所有的人员定位设备编号信息
   	List<VehicleInfo> selectAllCarDevid();
    
}