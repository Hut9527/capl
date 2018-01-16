package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.UnitTypeMapper;
import com.sunjays.capl.entity.UnitType;
import com.sunjays.capl.entity.UnitTypeExample;
import com.sunjays.capl.service.UnitTypeService;
@Service
@Transactional
public class UnitTypeServiceImpl implements UnitTypeService {
	@Resource
	private UnitTypeMapper unitTypeMapper;
	/**
	 * 加载所有组类型(单位)信息
	 */
	@Override
	public List<UnitType> selectAllUtit() {
		UnitTypeExample example = new UnitTypeExample();
		return unitTypeMapper.selectByExample(example);
	}
	//根据类型id查找具体类型对象
	@Override
	public UnitType selectById(Integer unitypeid) {
		return unitTypeMapper.selectByPrimaryKey(unitypeid);
	}
	
}
