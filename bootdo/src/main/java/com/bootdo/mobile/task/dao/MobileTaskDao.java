package com.bootdo.mobile.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bootdo.mobile.task.domain.MobileTask;

public interface MobileTaskDao extends JpaRepository< MobileTask,Long>,JpaSpecificationExecutor<MobileTask>{
	
	

}
