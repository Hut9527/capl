package com.sunjays.capl.service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.sunjays.capl.dao.VehicleTypeMapper;
import com.sunjays.capl.entity.VehicleType;
import com.sunjays.capl.entity.VehicleTypeExample;
import com.sunjays.capl.service.VehicleTypeService;
@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {
	@Autowired
	private VehicleTypeMapper vehicleTypeMapper;
	@Override
	public int countByExample(VehicleTypeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(VehicleTypeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(VehicleType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(VehicleType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VehicleType> selectByExample(VehicleTypeExample example) {
		// TODO Auto-generated method stub
		return vehicleTypeMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(VehicleType record,
			VehicleTypeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(VehicleType record, VehicleTypeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
