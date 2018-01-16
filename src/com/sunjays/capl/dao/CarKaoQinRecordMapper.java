package com.sunjays.capl.dao;

import java.util.List;
import java.util.Map;

import com.sunjays.capl.entity.CarKaoQinRecord;

public interface CarKaoQinRecordMapper {
    int deleteByPrimaryKey(Long ckqid);

    int insert(CarKaoQinRecord record);

    int insertSelective(CarKaoQinRecord record);

    CarKaoQinRecord selectByPrimaryKey(Long ckqid);

    int updateByPrimaryKeySelective(CarKaoQinRecord record);

    int updateByPrimaryKey(CarKaoQinRecord record);

	List<CarKaoQinRecord> selectCarRecordByMap(Map<String, Object> sqlMap);
}