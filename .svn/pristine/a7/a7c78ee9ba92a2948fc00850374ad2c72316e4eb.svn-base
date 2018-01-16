package com.sunjays.capl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunjays.capl.dao.VehicleInfoMapper;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;
import com.sunjays.capl.service.VehicleInfoService;
import com.sunjays.capl.utils.Md5Util;
@Service
@Transactional
public class VehicleInfoServiceImpl implements VehicleInfoService {
	@Autowired
	private VehicleInfoMapper  vehicleinfoMapper;
	

	@Override
	public int countByExample(VehicleInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(VehicleInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(VehicleInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(VehicleInfo vehicleinfo) {
		
		return vehicleinfoMapper.insertSelective(vehicleinfo);
	}

	@Override
	public List<VehicleInfo> selectByExample(VehicleInfoExample example) {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.selectByExample(example);
	}

	@Override
	public VehicleInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(VehicleInfo record,
			VehicleInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(VehicleInfo record, VehicleInfoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(VehicleInfo record) {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VehicleInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VehicleInfo> selectAll() {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.selectAll();
	}

	@Override
	public VehicleInfo selectVehicleById(String id) {
		int idd = Integer.parseInt(id);
		return vehicleinfoMapper.selectByPrimaryKey(idd);
	}

	@Override
	public int deleteVehicleById(String id) {
		int idd = Integer.parseInt(id);
		return vehicleinfoMapper.deleteByPrimaryKey(idd);
	}
	//通过id查询车辆信息
	@Override
	public VehicleInfo selectVehicleById(VehicleInfo info) {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.selectByPrimaryKey(info.getId());
	}
	//增加或修改操作
	@Override
	public void addOrUpdateUser(VehicleInfo info) {
		
			
			vehicleinfoMapper.insertSelective(info);
	
		
	}
	//根据公司名称查询公司下所有人员信息
	@Override
	public List<VehicleInfo> selectVehicleByCompany(String company) {
		VehicleInfoExample example = new VehicleInfoExample();
		if (company!=null&&company!="") {
			example.createCriteria().andCompanyEqualTo(company);
		}
		return vehicleinfoMapper.selectByExample(example);
	}

	@Override
	public VehicleInfo selectDevidById(VehicleInfo ui) {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.selectByPrimaryKey(ui.getId());
	}

	@Override
	public VehicleInfo selectByDevid(String devid) {
		VehicleInfoExample example = new VehicleInfoExample();
		example.createCriteria().andDevidEqualTo(devid);
		List<VehicleInfo> list = vehicleinfoMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public VehicleInfo selectVehicleByIds(VehicleInfo ui) {
		// TODO Auto-generated method stub
		return vehicleinfoMapper.selectByPrimaryKey(ui.getId());
	}

	@Override
	public VehicleInfo selectByVehicle(String vehicle) {
		VehicleInfoExample example = new VehicleInfoExample();
		example.createCriteria().andVehicleEqualTo(vehicle);
		List<VehicleInfo> list = vehicleinfoMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public VehicleInfo selectSimnumberById(VehicleInfo ui) {
		
		return vehicleinfoMapper.selectByPrimaryKey(ui.getId());
	}

	@Override
	public VehicleInfo selectBySimnumber(String simnumber) {
		VehicleInfoExample example = new VehicleInfoExample();
		example.createCriteria().andSimnumberEqualTo(simnumber);
		List<VehicleInfo> list = vehicleinfoMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
