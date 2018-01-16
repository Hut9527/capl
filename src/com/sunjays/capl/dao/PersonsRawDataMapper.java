package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.PersonsRawDataExample;
import com.sunjays.capl.entity.PersonsVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PersonsRawDataMapper {
    int countByExample(PersonsRawDataExample example);

    int deleteByExample(PersonsRawDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonsRawData record);

    int insertSelective(PersonsRawData record);

    List<PersonsRawData> selectByExample(PersonsRawDataExample example);

    PersonsRawData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonsRawData record, @Param("example") PersonsRawDataExample example);

    int updateByExample(@Param("record") PersonsRawData record, @Param("example") PersonsRawDataExample example);

    int updateByPrimaryKeySelective(PersonsRawData record);

    int updateByPrimaryKey(PersonsRawData record);
    
    //查询每个人最后一个坐标
    List<PersonsRawData> selectByLastTime();
    
    //查詢每個人最新坐標
    List<PersonsRawData> selectAll(String time);
    
    //查询每个人最新的坐标
    PersonsRawData selectByDevId(String DevId);
    
    //根据姓名和手机号模糊查询
    PersonsRawData selectByPersons(PersonsInfo personsInfo);
    
    //模糊查询最新坐标
    List<PersonsRawData> selectByLike(PersonsInfo personsInfo);
    
    //模糊查询最后一个坐标
    List<PersonsRawData> selectByLastLike(PersonsInfo personsInfo);
    
    //根据姓名和时间查询坐标
    List<PersonsRawData> selectByVo(PersonsVo vo);
    
    //根据条件统计上班时间
    List<PersonsRawData> recordPersonKaoQinByMap(Map<String, Object> sqlmap);
    //根据Phone号查询
    PersonsRawData selectByPhone(PersonsInfo personsinfo);
    //根据Phone查询最后一个
    PersonsRawData selectByLastPhone(String phone);
    
    //查询没有状态的车辆
    List<PersonsRawData> selectByRemark();
    
    //给状态赋值
    void updateRemark(PersonsRawData veh);
    
    //查询需要报表统计的数据
    List<PersonsRawData> selectByFlag(PersonsRawData per);
    
    //已经统计
    void updateFlag(String name);
    
    //查询人员报警信息
    List<PersonsRawData> selectByWarnTime(AttendanceTimeVo time);
}