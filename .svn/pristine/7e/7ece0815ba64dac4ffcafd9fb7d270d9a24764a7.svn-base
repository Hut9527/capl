package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.CarAttendanceMapper;
import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.CarAttendanceExample;
import com.sunjays.capl.service.CarAttendanceService;
@Service
@Transactional
public class CarAttendanceServiceImpl implements CarAttendanceService {
	
	@Autowired
	private CarAttendanceMapper dao;
	
	@Override
	public int countByExample(CarAttendanceExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(CarAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CarAttendance record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(CarAttendance record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public List<CarAttendance> selectByExample(CarAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.selectByExample(example);
	}

	@Override
	public CarAttendance selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CarAttendance record, CarAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CarAttendance record, CarAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CarAttendance record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CarAttendance record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	//根据时间查询所有数据
	public List<CarAttendance> selectByTime(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByTime(time);
	}

    //查询重复违章段(1)
	public CarAttendance selectByViolat1(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolat1(time);
	}

    //查询重复违章段(2)
	public List<CarAttendance> selectByViolat2(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolat2(time);
	}

    //查询重复违章类型
	public String selectByViolatdate(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolatdate(time);
	}

}
