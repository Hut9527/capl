package com.sunjays.capl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjays.capl.dao.CarKaoQinRecordMapper;
import com.sunjays.capl.entity.CarKaoQinRecord;
import com.sunjays.capl.service.CarKaoQinRecordService;
@Service
public class CarKaoQinRecordServiceImpl implements CarKaoQinRecordService {

	@Resource
	private CarKaoQinRecordMapper carKaoQinRecordMapper;
	@Override
	public List<CarKaoQinRecord> selectPersonRecordByMap(Map<String, Object> sqlMap) {
		
		return carKaoQinRecordMapper.selectCarRecordByMap(sqlMap);
	}

}
