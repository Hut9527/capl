package com.sunjays.capl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.UserUnitMapper;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.service.UnitTypeService;
import com.sunjays.capl.service.UserUnitService;
@Service
@Transactional
public class UserUnitServiceImpl implements UserUnitService {
	@Resource
	private UserUnitMapper uum;
	@Resource
	private UnitTypeService ut;
	@Override
	public int adddanwei(UserUnit unit) {
		if (unit.getUuid()==null) {
			return uum.insert(unit);
		}
		return uum.updateByPrimaryKeySelective(unit);
	}
	@Override
	public List<UserUnit> selectFenye() {
		UserUnitExample example = new UserUnitExample();
		List<UserUnit> list = uum.selectByExample(example);
		for (UserUnit userUnit : list) {
			userUnit.setUnitType(ut.selectById(userUnit.getUnitypeid()));
		}
		return list;
	}
	@Override
	public List<UserUnit> selectRoleList() {
		UserUnitExample example = new UserUnitExample();
		return uum.selectByExample(example);
	}
	@Override
	public UserUnit selectZuById(Integer id) {
		return uum.selectByPrimaryKey(id);
	}
	@Override
	public void deleteUserGroupById(Integer ugid) {
		uum.deleteByPrimaryKey(ugid);
		
	}
	@Override
	public UserUnit selectUserByUserId(Integer id) {
		
		return uum.selectByPrimaryKey(id);
	}
	@Override
	public UserUnit selectByGroupName(String name) {
		UserUnitExample example = new UserUnitExample();
		example.createCriteria().andUunameEqualTo(name);
		List<UserUnit> list = uum.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public List<UserUnit> selectByExample(UserUnitExample example) {
		// TODO Auto-generated method stub
		return uum.selectByExample(example);
	}

}
