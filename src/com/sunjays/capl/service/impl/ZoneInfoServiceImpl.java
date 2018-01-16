package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.ZoneInfoMapper;
import com.sunjays.capl.entity.ZoneInfo;
import com.sunjays.capl.entity.ZoneInfoExample;
import com.sunjays.capl.entity.ZoneVo;
import com.sunjays.capl.service.ZoneInfoService;
@Service
@Transactional
public class ZoneInfoServiceImpl implements ZoneInfoService {
	
	@Autowired
	private ZoneInfoMapper zone;

	@Override
	public int countByExample(ZoneInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(ZoneInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return zone.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ZoneInfo record) {
		// TODO Auto-generated method stub
		return zone.insert(record);
	}

	@Override
	public int insertSelective(ZoneInfo record) {
		// TODO Auto-generated method stub
		return zone.insertSelective(record);
	}

	@Override
	public List<ZoneInfo> selectByExample(ZoneInfoExample example) {
		// TODO Auto-generated method stub
		return zone.selectByExample(example);
	}

	@Override
	public ZoneInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return zone.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ZoneInfo record, ZoneInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(ZoneInfo record, ZoneInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(ZoneInfo record) {
		// TODO Auto-generated method stub
		return zone.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZoneInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ZoneVo> selectAll() {
		// TODO Auto-generated method stub
		return zone.selectAll();
	}

	//姓名查询信息
	public ZoneInfo selectByName(String name) {
		// TODO Auto-generated method stub
		return zone.selectByName(name);
	}

	//车牌查询信息
	public ZoneInfo selectByVehicle(String vehicle) {
		// TODO Auto-generated method stub
		return zone.selectByVehicle(vehicle);
	}

}
