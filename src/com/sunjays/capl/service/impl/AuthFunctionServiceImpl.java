package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.AuthFunctionMapper;
import com.sunjays.capl.entity.AuthFunction;
import com.sunjays.capl.entity.AuthFunctionExample;
import com.sunjays.capl.service.AuthFunctionService;
@Service
@Transactional
public class AuthFunctionServiceImpl implements AuthFunctionService {
	@Resource
	private AuthFunctionMapper afm;
	@Override
	public List<AuthFunction> selectMenuFunction() {
		AuthFunctionExample example = new AuthFunctionExample();
		example.createCriteria().andParentidEqualTo(0);
		return afm.selectByExample(example);
	}
	@Override
	public List<AuthFunction> selectMenuByParentId(AuthFunction af) {
		AuthFunctionExample example = new AuthFunctionExample();
		example.createCriteria().andParentidEqualTo(af.getParentid());
		return afm.selectByExample(example);
	}

}