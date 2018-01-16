package com.sunjays.capl.dao;

import com.sunjays.capl.entity.AuthRole;
import com.sunjays.capl.entity.AuthRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleMapper {
    int countByExample(AuthRoleExample example);

    int deleteByExample(AuthRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    List<AuthRole> selectByExample(AuthRoleExample example);

    AuthRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByExample(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);
}