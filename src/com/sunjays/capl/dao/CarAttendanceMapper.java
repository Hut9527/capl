package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.CarAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarAttendanceMapper {
    int countByExample(CarAttendanceExample example);

    int deleteByExample(CarAttendanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarAttendance record);

    int insertSelective(CarAttendance record);

    List<CarAttendance> selectByExample(CarAttendanceExample example);

    CarAttendance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarAttendance record, @Param("example") CarAttendanceExample example);

    int updateByExample(@Param("record") CarAttendance record, @Param("example") CarAttendanceExample example);

    int updateByPrimaryKeySelective(CarAttendance record);

    int updateByPrimaryKey(CarAttendance record);
    
    //根据时间查询所有数据
    List<CarAttendance> selectByTime(AttendanceTimeVo time);
    
    //查询重复违章段(1)
    CarAttendance selectByViolat1(AttendanceTimeVo time);
    
    //查询重复违章段(2)
    List<CarAttendance> selectByViolat2(AttendanceTimeVo time);
    
    //查询重复违章类型
    String selectByViolatdate(AttendanceTimeVo time);
    
}