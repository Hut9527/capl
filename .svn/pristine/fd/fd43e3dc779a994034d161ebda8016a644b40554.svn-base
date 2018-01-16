package com.sunjays.capl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;

public interface VehicleInfoService {

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

	VehicleInfo selectVehicleById(String id);
	//删除车辆信息
	int deleteVehicleById(String id);
	//通过id查询车辆信息
	VehicleInfo selectVehicleById(VehicleInfo info);
	//添加或修改车辆信息
	 public void addOrUpdateUser(VehicleInfo info);
	 
	 public List<VehicleInfo> selectVehicleByCompany(String company);

	VehicleInfo selectDevidById(VehicleInfo ui);

	VehicleInfo selectByDevid(String devid);
	//验证车牌号是否重复
	VehicleInfo selectVehicleByIds(VehicleInfo ui);

	VehicleInfo selectByVehicle(String vehicle);
	//验证SIM卡号是否重复
	VehicleInfo selectSimnumberById(VehicleInfo ui);

	VehicleInfo selectBySimnumber(String simnumber);
}
