package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.AuthRoleMapper;
import com.sunjays.capl.dao.RoleFunctionMapper;
import com.sunjays.capl.entity.AuthRole;
import com.sunjays.capl.entity.AuthRoleExample;
import com.sunjays.capl.entity.RoleFunctionExample;
import com.sunjays.capl.entity.RoleFunctionKey;
import com.sunjays.capl.service.AuthRoleService;
@Service
@Transactional
public class AuthRoleServiceImpl implements AuthRoleService {
	@Resource
	private AuthRoleMapper arm;
	@Resource
	private RoleFunctionMapper rfm;
	
	@Override
	public List<AuthRole> selectRoleList() {
		AuthRoleExample example = new AuthRoleExample();
		return arm.selectByExample(example);
	}
	/**
	 * 添加角色/修改角色
	 */
	@Override
	public void insertOrUpdateRole(AuthRole ar, String menuIds) {
		if (ar.getRoleid()==null) {
			arm.insert(ar);
		}else {
			arm.updateByPrimaryKeySelective(ar);
			RoleFunctionExample example = new RoleFunctionExample();
			example.createCriteria().andRoleidEqualTo(ar.getRoleid());
			rfm.deleteByExample(example);
		}
		String[] fid = menuIds.split(",");
		RoleFunctionKey record = new RoleFunctionKey();
		record.setRoleid(ar.getRoleid());
		for (int i = 0; i < fid.length; i++) {
	        if(fid[i]!=null&&!fid[i].trim().equals("")){
	        	Integer menuId=Integer.parseInt(fid[i]);
	        	record.setFunctionid(menuId);
	        	rfm.insertSelective(record);
	        }
	    }
		
	}
	//根据角色id查找对应角色
	@Override
	public AuthRole selectRoleByRoleId(int roleid) {
		return arm.selectByPrimaryKey(roleid);
	}
	@Override
	public List<RoleFunctionKey> selectFunctionIdByRoleId(int roleid) {
		RoleFunctionExample example = new RoleFunctionExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		return rfm.selectByExample(example);
	}
	/**
	 * 根据角色id删除角色
	 */
	@Override
	public void deleteRoleById(Integer roleid) {

		RoleFunctionExample example = new RoleFunctionExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		rfm.deleteByExample(example);
		
		arm.deleteByPrimaryKey(roleid);
	}
	@Override
	public AuthRole selectByRoleName(String rolename) {
		AuthRoleExample example = new AuthRoleExample();
		example.createCriteria().andRolenameEqualTo(rolename);
		List<AuthRole> list = arm.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	
}
