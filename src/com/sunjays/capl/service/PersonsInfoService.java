package com.sunjays.capl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;
import com.sunjays.capl.entity.VehicleInfo;

public interface PersonsInfoService {

	int countByExample(PersonsInfoExample example);

    int deleteByExample(PersonsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonsInfo record);

    int insertSelective(PersonsInfo record);

    List<PersonsInfo> selectByExample(PersonsInfoExample example);

    PersonsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonsInfo record, @Param("example") PersonsInfoExample example);

    int updateByExample(@Param("record") PersonsInfo record, @Param("example") PersonsInfoExample example);

    int updateByPrimaryKeySelective(PersonsInfo record);

    int updateByPrimaryKey(PersonsInfo record);
    //查询所有的人员信息
	List<PersonsInfo> selectRyxxAll();
	//修改时通过id查询人员信息
	PersonsInfo selectVehicleById(String id);
	//通过id查询车辆信息
	PersonsInfo selectVehicleById(PersonsInfo info);

	public void addOrupdatepeople(PersonsInfo info);

	int deletePersonById(String id);
	
	 public List<PersonsInfo> selectPersonsByCompany(String company);
	 //校验simnumber是否重复
	PersonsInfo selectSimnumberById(PersonsInfo ui);

	PersonsInfo selectBySimnumber(String simnumber);
	//输入工号查询人员信息
	PersonsInfo selectPersonByJobNumber(String jobnumber);

	

	
	
}
