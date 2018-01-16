package com.sunjays.capl.service;

import com.sunjays.capl.entity.SystemLog;

public interface SystemLogService {
	int deleteSystemLog(String id);
	 
    int insert(SystemLog record);
    
    int insertTest(SystemLog record);

    SystemLog selectSystemLog(String id);
    
    int updateSystemLog(SystemLog record);
}
