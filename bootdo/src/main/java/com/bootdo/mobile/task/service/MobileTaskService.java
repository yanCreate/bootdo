package com.bootdo.mobile.task.service;

import java.util.List;
import java.util.Map;

import com.bootdo.mobile.task.domain.MobileTask;

public interface MobileTaskService {
	
	MobileTask findById(Long taskId);
	
	List<MobileTask> list(Map<String, Object> map);

	MobileTask save(MobileTask task);

	void remove(Long taskId);
}
