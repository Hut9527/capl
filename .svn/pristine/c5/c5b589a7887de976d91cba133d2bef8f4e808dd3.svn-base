package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.UserAttendanceMapper;
import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.UserAttendanceExample;
import com.sunjays.capl.service.UserAttendanceService;
@Service
@Transactional
public class UserAttendanceServiceImpl implements UserAttendanceService {

	@Autowired
	private UserAttendanceMapper dao;
	
	@Override
	public int countByExample(UserAttendanceExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(UserAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserAttendance record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(UserAttendance record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public List<UserAttendance> selectByExample(UserAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.selectByExample(example);
	}

	@Override
	public UserAttendance selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(UserAttendance record, UserAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UserAttendance record, UserAttendanceExample example) {
		// TODO Auto-generated method stub
		return dao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAttendance record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserAttendance record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	//根据时间查询所有数据
	public List<UserAttendance> selectByTime(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByTime(time);
	}

    //查询重复违章段(1)
	public UserAttendance selectByViolat1(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolat1(time);
	}

    //查询重复违章段(2)
	public List<UserAttendance> selectByViolat2(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolat2(time);
	}

    //查询重复违章类型
	public String selectByViolatdate(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return dao.selectByViolatdate(time);
	}

}
