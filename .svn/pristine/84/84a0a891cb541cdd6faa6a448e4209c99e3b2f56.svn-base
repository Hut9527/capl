package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.CheckAreaMapper;
import com.sunjays.capl.entity.CheckArea;
import com.sunjays.capl.entity.CheckAreaExample;
import com.sunjays.capl.service.CheckAreaService;
@Service
@Transactional
public class CheckAreaServiceImpl implements CheckAreaService {

	@Resource
	private CheckAreaMapper cam;
	@Override
	public List<CheckArea> selectAllCheckAreaFenye() {
		CheckAreaExample example = new CheckAreaExample();
		List<CheckArea> list = cam.selectByExample(example);
		return list;
	}
	@Override
	public int countByExample(CheckAreaExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteByExample(CheckAreaExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteByPrimaryKey(Integer wkid) {
		// TODO Auto-generated method stub
		return cam.deleteByPrimaryKey(wkid);
	}
	@Override
	public int insert(CheckArea record) {
		// TODO Auto-generated method stub
		return cam.insert(record);
	}
	@Override
	public int insertSelective(CheckArea record) {
		// TODO Auto-generated method stub
		return cam.insertSelective(record);
	}
	@Override
	public List<CheckArea> selectByExample(CheckAreaExample example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CheckArea selectByPrimaryKey(Integer wkid) {
		// TODO Auto-generated method stub
		return cam.selectByPrimaryKey(wkid);
	}
	@Override
	public int updateByExampleSelective(CheckArea record, CheckAreaExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByExample(CheckArea record, CheckAreaExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKeySelective(CheckArea record) {
		// TODO Auto-generated method stub
		return cam.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(CheckArea record) {
		// TODO Auto-generated method stub
		return cam.updateByPrimaryKey(record);
	}

}
