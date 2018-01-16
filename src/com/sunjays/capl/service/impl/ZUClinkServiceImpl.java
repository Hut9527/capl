package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.ZUClinkMapper;
import com.sunjays.capl.entity.ZUClink;
import com.sunjays.capl.entity.ZUClinkExample;
import com.sunjays.capl.service.ZUClinkService;
@Service
@Transactional
public class ZUClinkServiceImpl implements ZUClinkService{
	
	@Autowired
	private ZUClinkMapper dao;
	
	@Override
	public int countByExample(ZUClinkExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(ZUClinkExample example) {
		// TODO Auto-generated method stub
		return dao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ZUClink record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(ZUClink record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public List<ZUClink> selectByExample(ZUClinkExample example) {
		// TODO Auto-generated method stub
		return dao.selectByExample(example);
	}

	@Override
	public ZUClink selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(ZUClink record, ZUClinkExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(ZUClink record, ZUClinkExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(ZUClink record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZUClink record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
