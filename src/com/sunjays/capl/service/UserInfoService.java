package com.sunjays.capl.service;

import java.util.List;

import com.sunjays.capl.entity.AuthFunction;
import com.sunjays.capl.entity.UserInfo;

public interface UserInfoService {

	public List<UserInfo> selectUserInfoFenye();
   
	public void addOrUpdateUser(UserInfo ui);
   
	public UserInfo selectUserByUserId(UserInfo ui);
    
	public void deleteUserInfoById(Integer userid);
 
	public int selectYongHuByRoleId(Integer roleid);
 
	public UserInfo selectByAdminName(String username);
 
	public void updateUserInfo(UserInfo userInfo);

	public List<AuthFunction> findFunctionsByUserId(Integer userid);

	public List<AuthFunction> selectParFunction();
	
}
