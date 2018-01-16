package com.sunjays.capl.service;

import java.util.List;

import com.sunjays.capl.entity.AuthFunction;

public interface AuthFunctionService {
	public List<AuthFunction> selectMenuFunction();

	public List<AuthFunction> selectMenuByParentId(AuthFunction af);

}
