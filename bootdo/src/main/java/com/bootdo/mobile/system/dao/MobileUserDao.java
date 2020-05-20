package com.bootdo.mobile.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bootdo.mobile.system.domain.MobileUser;

public interface MobileUserDao extends JpaRepository<MobileUser, Long>, JpaSpecificationExecutor<MobileUser> {

}
