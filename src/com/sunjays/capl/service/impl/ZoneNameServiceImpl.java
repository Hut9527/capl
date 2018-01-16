package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.ZoneNameMapper;
import com.sunjays.capl.entity.ZoneName;
import com.sunjays.capl.entity.ZoneNameExample;
import com.sunjays.capl.service.ZoneNameService;
@Service
@Transactional
public class ZoneNameServiceImpl implements ZoneNameService {

	@Autowired
	private ZoneNameMapper zone;
	
	@Override
	public int countByExample(ZoneNameExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(ZoneNameExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer wkid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ZoneName record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ZoneName record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ZoneName> selectByExample(ZoneNameExample example) {
		// TODO Auto-generated method stub
		return zone.selectByExample(example);
	}

	@Override
	public ZoneName selectByPrimaryKey(Integer wkid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(ZoneName record, ZoneNameExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(ZoneName record, ZoneNameExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(ZoneName record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ZoneName record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
