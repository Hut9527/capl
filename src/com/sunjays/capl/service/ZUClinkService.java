package com.sunjays.capl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunjays.capl.entity.ZUClink;
import com.sunjays.capl.entity.ZUClinkExample;

public interface ZUClinkService {
	
	int countByExample(ZUClinkExample example);

    int deleteByExample(ZUClinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZUClink record);

    int insertSelective(ZUClink record);

    List<ZUClink> selectByExample(ZUClinkExample example);

    ZUClink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZUClink record, @Param("example") ZUClinkExample example);

    int updateByExample(@Param("record") ZUClink record, @Param("example") ZUClinkExample example);

    int updateByPrimaryKeySelective(ZUClink record);

    int updateByPrimaryKey(ZUClink record);

}
