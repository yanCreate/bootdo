package com.bootdo.common.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootdo.mobile.system.service.impl.MobileUserService;
import com.bootdo.mobile.task.service.MobileTaskService;

/**
 * 服务工厂
 * @Author yigeyanse@hotmail.com
 * @Date 2017年9月6日 上午10:10:20
 */
@Component
public class ServiceManager {

	
	public static MobileTaskService taskService;
	public static MobileUserService userService;
	
	@Autowired
	public void setEsAccountInfoService(MobileTaskService taskService) {
		ServiceManager.taskService = taskService;
	}
	
	@Autowired
	public void setEsAccountInfoService(MobileUserService userService) {
		ServiceManager.userService = userService;
	}
}
