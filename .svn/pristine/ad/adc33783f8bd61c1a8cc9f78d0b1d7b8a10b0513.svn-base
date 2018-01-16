package com.sunjays.capl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjays.capl.dao.PersonKaoQinRecordMapper;
import com.sunjays.capl.entity.PersonKaoQinRecord;
import com.sunjays.capl.service.PersonKaoQinRecordService;
@Service
public class PersonKaoQinRecordServiceImpl implements PersonKaoQinRecordService {

	@Resource
	private PersonKaoQinRecordMapper personKaoQinRecordMapper;
	@Override
	public List<PersonKaoQinRecord> selectPersonRecordByMap(Map<String, Object> sqlMap) {
		return personKaoQinRecordMapper.selectPersonRecordByMap(sqlMap);
	}

}
