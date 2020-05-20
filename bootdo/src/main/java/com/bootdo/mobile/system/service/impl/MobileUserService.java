package com.bootdo.mobile.system.service.impl;

import java.util.List;
import java.util.Map;

import com.bootdo.mobile.system.domain.MobileUser;

public interface MobileUserService {
	
	MobileUser findById(Long id);
	MobileUser save(MobileUser user);
	List<MobileUser> list(Map<String, Object> map);
	void remove(Long taskId);
}
