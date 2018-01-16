package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.UserAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttendanceMapper {
    int countByExample(UserAttendanceExample example);

    int deleteByExample(UserAttendanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAttendance record);

    int insertSelective(UserAttendance record);

    List<UserAttendance> selectByExample(UserAttendanceExample example);

    UserAttendance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAttendance record, @Param("example") UserAttendanceExample example);

    int updateByExample(@Param("record") UserAttendance record, @Param("example") UserAttendanceExample example);

    int updateByPrimaryKeySelective(UserAttendance record);

    int updateByPrimaryKey(UserAttendance record);
    
    //根据时间查询所有数据
    List<UserAttendance> selectByTime(AttendanceTimeVo time);
    
    //查询重复违章段(1)
    UserAttendance selectByViolat1(AttendanceTimeVo time);
    
    //查询重复违章段(2)
    List<UserAttendance> selectByViolat2(AttendanceTimeVo time);
    
    //查询重复违章类型
    String selectByViolatdate(AttendanceTimeVo time);
    
}