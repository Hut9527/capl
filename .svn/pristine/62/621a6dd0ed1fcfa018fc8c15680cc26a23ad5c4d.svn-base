package com.sunjays.capl.dao;

import java.util.List;
import java.util.Map;

import com.sunjays.capl.entity.PersonKaoQinRecord;

public interface PersonKaoQinRecordMapper {
    int deleteByPrimaryKey(Long pkqid);

    int insert(PersonKaoQinRecord record);

    int insertSelective(PersonKaoQinRecord record);

    PersonKaoQinRecord selectByPrimaryKey(Long pkqid);

    int updateByPrimaryKeySelective(PersonKaoQinRecord record);

    int updateByPrimaryKey(PersonKaoQinRecord record);

	List<PersonKaoQinRecord> selectPersonRecordByMap(Map<String, Object> sqlMap);
}