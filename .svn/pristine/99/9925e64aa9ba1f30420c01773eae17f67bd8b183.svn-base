package com.sunjays.capl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunjays.capl.entity.VehicleType;
import com.sunjays.capl.entity.VehicleTypeExample;

public interface VehicleTypeService {
	int countByExample(VehicleTypeExample example);

    int deleteByExample(VehicleTypeExample example);

    int insert(VehicleType record);

    int insertSelective(VehicleType record);

    List<VehicleType> selectByExample(VehicleTypeExample example);

    int updateByExampleSelective(@Param("record") VehicleType record, @Param("example") VehicleTypeExample example);

    int updateByExample(@Param("record") VehicleType record, @Param("example") VehicleTypeExample example);
}
