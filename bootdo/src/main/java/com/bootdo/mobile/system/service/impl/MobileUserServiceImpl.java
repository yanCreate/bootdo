package com.bootdo.mobile.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bootdo.mobile.system.dao.MobileUserDao;
import com.bootdo.mobile.system.domain.MobileUser;

@Service	
public class MobileUserServiceImpl implements MobileUserService {

	@Autowired
	private MobileUserDao mobileUserDao;
	
	@Override
	public MobileUser findById(Long id) {
		return mobileUserDao.getOne(id);
	}

	@Override
	public MobileUser save(MobileUser user) {
		return mobileUserDao.saveAndFlush(user);
	}

	@Override
	public List<MobileUser> list(Map<String, Object> map) {
		
		List<MobileUser> userList =  mobileUserDao.findAll(new Specification<MobileUser>() {
			
			@Override
			public Predicate toPredicate(Root<MobileUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (StringUtils.isNotBlank((String) map.get("name"))) {
					list.add(cb.like(root.get("name").as(String.class), "%" + map.get("name") + "%"));
				}

				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		});
		return userList;
	}

	@Override
	public void remove(Long id) {
		mobileUserDao.delete(id);
	}

}
