package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.entity.VehicleRawDataExample;
import com.sunjays.capl.entity.VehicleVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface VehicleRawDataMapper {
    int countByExample(VehicleRawDataExample example);

    int deleteByExample(VehicleRawDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleRawData record);

    int insertSelective(VehicleRawData record);

    List<VehicleRawData> selectByExample(VehicleRawDataExample example);

    VehicleRawData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleRawData record, @Param("example") VehicleRawDataExample example);

    int updateByExample(@Param("record") VehicleRawData record, @Param("example") VehicleRawDataExample example);

    int updateByPrimaryKeySelective(VehicleRawData record);

    int updateByPrimaryKey(VehicleRawData record);
    
    //查询每个车最后一个坐标
    List<VehicleRawData> selectByLastTime();
    
    //查询每个车最新坐标
    List<VehicleRawData> selectAll(String time);
    
    //查询一辆车最新坐标
    VehicleRawData selectByDevId(String DevId);
    
    //根据车牌号或SIM号模糊查询
    VehicleRawData selectByVehicle(VehicleInfo vehicleInfo);
    
    //模糊查询最新坐标
    List<VehicleRawData> selectByLike(VehicleInfo vehicleInfo);
    
    //模糊查询最后一个坐标
    List<VehicleRawData> selectByLastLike(VehicleInfo vehicleInfo);
    
    //根据设备码和时间查询
    List<VehicleRawData> selectByVo(VehicleVo vo);
    
    //根据条件统计上班时间 
    List<VehicleRawData> recordCarKaoQinByMap(Map<String, Object> sqlmap);
    
    //根据车牌号查询最新坐标
    VehicleRawData selectByVeh(VehicleInfo vehicleInfo);
    
    //根据车牌号查询最后一个坐标
    VehicleRawData selectByLastVeh(String veh);
    
    //查询没有状态的车辆
    List<VehicleRawData> selectByRemark();
    
    //给状态赋值
    void updateRemark(VehicleRawData veh);
    
    //查询需要报表统计的数据
    List<VehicleRawData> selectByFlag(VehicleRawData veh);
    
    //已经统计
    void updateFlag(String vehicle);
    
    //查询最早数据时间(车为基准)
    Date selectByLastGetTime();
    
    //查询车辆报警信息
    List<VehicleRawData> selectByWarnTime(AttendanceTimeVo time);
    
}