package com.sunjays.capl.service;

import java.util.List;

import com.sunjays.capl.entity.AuthRole;
import com.sunjays.capl.entity.RoleFunctionKey;

public interface AuthRoleService {
	public List<AuthRole> selectRoleList();

	public void insertOrUpdateRole(AuthRole ar, String menuIds);

	public AuthRole selectRoleByRoleId(int parseInt);

	public List<RoleFunctionKey> selectFunctionIdByRoleId(int parseInt);

	public void deleteRoleById(Integer roleid);

	public AuthRole selectByRoleName(String rolename);
}
