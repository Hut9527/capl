package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.AuthFunctionMapper;
import com.sunjays.capl.dao.AuthRoleMapper;
import com.sunjays.capl.dao.UserInfoMapper;
import com.sunjays.capl.dao.UserUnitMapper;
import com.sunjays.capl.entity.AuthFunction;
import com.sunjays.capl.entity.AuthFunctionExample;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.entity.UserInfoExample;
import com.sunjays.capl.service.UserInfoService;
import com.sunjays.capl.utils.Md5Util;
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	
	@Resource
	private UserInfoMapper uifm;
	@Resource
	private UserUnitMapper uum;
	@Resource
	private AuthRoleMapper arm;
	@Resource
	private AuthFunctionMapper afm;
	/**
	 * 加载用户信息列表
	 */
	@Override
	public List<UserInfo> selectUserInfoFenye() {
		UserInfoExample example = new UserInfoExample();
		List<UserInfo> list = uifm.selectByExample(example);
		
		for (UserInfo ui : list) {
			ui.setUserUnit(uum.selectByPrimaryKey(ui.getUserunitid()));
			ui.setAuthRole(arm.selectByPrimaryKey(ui.getRoleid()));
		}
		return list;
	}
	/**
	 * 添加/修改用户信息
	 */
	@Override
	public void addOrUpdateUser(UserInfo ui) {
		if (ui.getUserid()==null) {
			ui.setPassword(Md5Util.MD5Encode(ui.getPassword()));
			uifm.insert(ui);
		}else {
			ui.setPassword(Md5Util.MD5Encode(ui.getPassword()));
			uifm.updateByPrimaryKeySelective(ui);
		}
	}
	/**
	 * 根据用户id查找用户信息
	 */
	@Override
	public UserInfo selectUserByUserId(UserInfo ui) {
		return uifm.selectByPrimaryKey(ui.getUserid());
	}
	@Override
	public void deleteUserInfoById(Integer userid) {
		uifm.deleteByPrimaryKey(userid);
		
	}
	@Override
	public int selectYongHuByRoleId(Integer roleid) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		return uifm.countByExample(example );
	}
	@Override
	public UserInfo selectByAdminName(String username) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UserInfo> list = uifm.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		uifm.updateByPrimaryKeySelective(userInfo);
		
	}

	/**
	 * 根据用户id加载所有权限信息
	 */
	@Override
	public List<AuthFunction> findFunctionsByUserId(Integer userid) {
		return afm.selectAllFunctionByUserId(userid);
	}
	@Override
	public List<AuthFunction> selectParFunction() {
		AuthFunctionExample example = new AuthFunctionExample();
		return afm.selectByExample(example);
	}
}


