package com.sunjays.capl.dao;

import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PersonsInfoMapper {
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
  //输入工号查询人员信息
  PersonsInfo selectPersonByJobNumber(String jobnumber);
  
  //查询所有的人员定位设备编号信息
 	List<PersonsInfo> selectAllPersonDevid();
}