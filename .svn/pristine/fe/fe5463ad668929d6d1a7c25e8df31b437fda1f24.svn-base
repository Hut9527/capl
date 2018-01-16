package com.sunjays.capl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.SystemLogMapper;
import com.sunjays.capl.entity.SystemLog;
import com.sunjays.capl.service.SystemLogService;
@Service
@Transactional
public class SystemLogServiceImpl implements SystemLogService {

	@Resource
    private SystemLogMapper systemLogMapper;

	@Override
	public int deleteSystemLog(String id) {
		return systemLogMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public int insert(SystemLog record) {
		return systemLogMapper.insertSelective(record);
	}

	@Override
	public int insertTest(SystemLog record) {
		return systemLogMapper.insert(record);
	}

	@Override
	public SystemLog selectSystemLog(String id) {
		return systemLogMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public int updateSystemLog(SystemLog record) {
		return systemLogMapper.updateByPrimaryKeySelective(record);
	}
   
}
