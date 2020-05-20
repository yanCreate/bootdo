package com.bootdo.mobile.task.service.impl;

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

import com.bootdo.mobile.task.dao.MobileTaskDao;
import com.bootdo.mobile.task.domain.MobileTask;
import com.bootdo.mobile.task.service.MobileTaskService;

@Service
public class MobileTaskServiceImpl implements MobileTaskService {

	@Autowired
	private MobileTaskDao mobileTaskDao;

	@Override
	public List<MobileTask> list(Map<String, Object> map) {
		List<MobileTask> taskList = mobileTaskDao.findAll(new Specification<MobileTask>() {

			@Override
			public Predicate toPredicate(Root<MobileTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (StringUtils.isNotBlank((String) map.get("name"))) {
					list.add(cb.like(root.get("name").as(String.class), "%" + map.get("name") + "%"));
				}

				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		});

		return taskList;
	}

	@Override
	public MobileTask save(MobileTask task) {
		return mobileTaskDao.saveAndFlush(task);
	}

	@Override
	public void remove(Long taskId) {
		mobileTaskDao.delete(taskId);
	}

	@Override
	public MobileTask findById(Long taskId) {
		return mobileTaskDao.getOne(taskId);
	}

}
