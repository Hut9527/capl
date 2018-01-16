package com.sunjays.capl.dao;

import com.sunjays.capl.entity.UserCarMa;
import com.sunjays.capl.entity.UserCarMaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCarMaMapper {
    int countByExample(UserCarMaExample example);

    int deleteByExample(UserCarMaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCarMa record);

    int insertSelective(UserCarMa record);

    List<UserCarMa> selectByExample(UserCarMaExample example);

    UserCarMa selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCarMa record, @Param("example") UserCarMaExample example);

    int updateByExample(@Param("record") UserCarMa record, @Param("example") UserCarMaExample example);

    int updateByPrimaryKeySelective(UserCarMa record);

    int updateByPrimaryKey(UserCarMa record);
    List<UserCarMa> selectByVo(UserCarMa record);
    
}