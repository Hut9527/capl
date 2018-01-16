package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunjays.capl.dao.PersonsRawDataMapper;
import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.PersonsRawDataExample;
import com.sunjays.capl.entity.PersonsVo;
import com.sunjays.capl.service.PersonsRawDataService;
@Service
public class PersonsRawDataServiceImpl implements PersonsRawDataService {

	@Autowired
	private PersonsRawDataMapper personsRawDataMapper;
	
	@Override
	public int countByExample(PersonsRawDataExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PersonsRawDataExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PersonsRawData record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PersonsRawData record) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.insertSelective(record);
	}

	@Override
	public List<PersonsRawData> selectByExample(PersonsRawDataExample example) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByExample(example);
	}

	@Override
	public PersonsRawData selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(PersonsRawData record, PersonsRawDataExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(PersonsRawData record, PersonsRawDataExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PersonsRawData record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(PersonsRawData record) {
		// TODO Auto-generated method stub
		return 0;
	}

    //查询一个人最新的坐标
	public PersonsRawData selectByDevId(String DevId) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByDevId(DevId);
	}

    //根据姓名和手机号模糊查询
	public PersonsRawData selectByPersons(PersonsInfo personsInfo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByPersons(personsInfo);
	}

    //模糊查询最新坐标
	public List<PersonsRawData> selectByLike(PersonsInfo personsInfo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByLike(personsInfo);
	}

    //查詢每個人最新坐標
	public List<PersonsRawData> selectAll(String time) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectAll(time);
	}

    //根据姓名和时间查询坐标
	public List<PersonsRawData> selectByVo(PersonsVo vo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByVo(vo);
	}

	  //查询每个人最后一个坐标
	public List<PersonsRawData> selectByLastTime() {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByLastTime();
	}

    //根据Phone号查询
	public PersonsRawData selectByPhone(PersonsInfo personsinfo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByPhone(personsinfo);
	}

	//根据Phone号查询最后一个
	public PersonsRawData selectByLastPhone(String phone) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByLastPhone(phone);
	}

    //模糊查询最后一个坐标
	public List<PersonsRawData> selectByLastLike(PersonsInfo personsInfo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByLastLike(personsInfo);
	}

	@Override
	public List<PersonsRawData> selectByRemark() {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByRemark();
	}

	@Override
	public void updateRemark(PersonsRawData veh) {
		// TODO Auto-generated method stub
		personsRawDataMapper.updateRemark(veh);
	}

	@Override
	public List<PersonsRawData> selectByFlag(PersonsRawData peo) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByFlag(peo);
	}

	@Override
	public void updateFlag(String name) {
		// TODO Auto-generated method stub
		personsRawDataMapper.updateFlag(name);
	}

	@Override
	public List<PersonsRawData> selectByWarnTime(AttendanceTimeVo time) {
		// TODO Auto-generated method stub
		return personsRawDataMapper.selectByWarnTime(time);
	}

	

}
