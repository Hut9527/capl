package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AuthFunction;
import com.sunjays.capl.entity.AuthFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthFunctionMapper {
    int countByExample(AuthFunctionExample example);

    int deleteByExample(AuthFunctionExample example);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    List<AuthFunction> selectByExample(AuthFunctionExample example);

    int updateByExampleSelective(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByExample(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

	List<AuthFunction> selectAllFunctionByUserId(Integer userid);
}