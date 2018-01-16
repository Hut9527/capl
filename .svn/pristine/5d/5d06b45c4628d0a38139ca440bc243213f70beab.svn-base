package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjays.capl.dao.UserCarMaMapper;
import com.sunjays.capl.entity.UserCarMa;
import com.sunjays.capl.entity.UserCarMaExample;
import com.sunjays.capl.service.UserCarMaService;
@Service
public class UserCarMaServiceImpl implements UserCarMaService {

	@Resource
	private UserCarMaMapper ucmm;
	@Override
	public List<UserCarMa> selectAllPerson(UserCarMaExample example) {
		return ucmm.selectByExample(example);
	}

	@Override
	public List<UserCarMa> selectAllCar() {
		UserCarMaExample example = new UserCarMaExample();
		example.createCriteria().andFlagEqualTo(1);
		return ucmm.selectByExample(example);
	}

	@Override
	public List<UserCarMa> selectByVo(UserCarMa userCarMa) {
		// TODO Auto-generated method stub
		return ucmm.selectByVo(userCarMa);
	}

}
