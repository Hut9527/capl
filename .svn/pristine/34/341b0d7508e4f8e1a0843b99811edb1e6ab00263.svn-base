package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunjays.capl.dao.PersonsInfoMapper;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.service.PersonsInfoService;
@Service
public class PersonsInfoServiceImpl implements PersonsInfoService {

	@Autowired
	private PersonsInfoMapper personsInfoMapper;
	
	@Override
	public int countByExample(PersonsInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PersonsInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PersonsInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PersonsInfo record) {
		// TODO Auto-generated method stub
		return personsInfoMapper.insertSelective(record);
	}

	@Override
	public List<PersonsInfo> selectByExample(PersonsInfoExample example) {
		// TODO Auto-generated method stub
		return personsInfoMapper.selectByExample(example);
	}

	@Override
	public PersonsInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(PersonsInfo record, PersonsInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(PersonsInfo record, PersonsInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PersonsInfo record) {
		// TODO Auto-generated method stub
		return personsInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonsInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//查询所有人员录入信息
	public List<PersonsInfo> selectRyxxAll() {
		// TODO Auto-generated method stub
		return personsInfoMapper.selectRyxxAll();
	}

	@Override
	public PersonsInfo selectVehicleById(String id) {
		int idd = Integer.parseInt(id);
		return personsInfoMapper.selectByPrimaryKey(idd);
	}

	@Override
	//通过id查询车辆信息
	public PersonsInfo selectVehicleById(PersonsInfo info) {
		// TODO Auto-generated method stub
		return personsInfoMapper.selectByPrimaryKey(info.getId());
	}

	@Override
	//增加或修改人员信息
	public void addOrupdatepeople(PersonsInfo info) {

				
				personsInfoMapper.insertSelective(info);
			
			
	}

	@Override
	//通过id删除人员录入信息
	public int deletePersonById(String id) {
		int idd = Integer.parseInt(id);
		return personsInfoMapper.deleteByPrimaryKey(idd);
	}
	//根据公司名称查询公司下所有人员信息
	@Override
	public List<PersonsInfo> selectPersonsByCompany(String company) {
		PersonsInfoExample example = new PersonsInfoExample();
		if (company!=null&&company!="") {
			example.createCriteria().andCompanyEqualTo(company);
		}
		return personsInfoMapper.selectByExample(example);
	}

	@Override
	public PersonsInfo selectSimnumberById(PersonsInfo ui) {
		
		return personsInfoMapper.selectByPrimaryKey(ui.getId());
	}

	@Override
	public PersonsInfo selectBySimnumber(String simnumber) {
		PersonsInfoExample example = new PersonsInfoExample();
		example.createCriteria().andSimnumberEqualTo(simnumber);
		List<PersonsInfo> list = personsInfoMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	//通过工号查询人员信息
	@Override
	public PersonsInfo selectPersonByJobNumber(String jobnumber) {
		
		return personsInfoMapper.selectPersonByJobNumber(jobnumber) ;
	}

	
	

}
