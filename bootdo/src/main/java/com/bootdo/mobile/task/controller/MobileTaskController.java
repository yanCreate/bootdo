package com.bootdo.mobile.task.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.helper.ServiceManager;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.mobile.task.domain.MobileTask;

@RestController
@RequestMapping(value = "/mobile/task")
public class MobileTaskController {

	/**
	 * 查询一个
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/findById/{id}")
	public MobileTask findTaskById(@PathVariable Long id) {
		return ServiceManager.taskService.findById(id);
	}

	/**
	 * 动态条件查询
	 * @param params
	 * @return
	 */
	@GetMapping("/list")
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<MobileTask> taskList = ServiceManager.taskService.list(query);
		int total = taskList.size();
		PageUtils pageUtil = new PageUtils(taskList, total);
		return pageUtil;
	}

	/**
	 * 发布任务
	 * @param task
	 * @param bindingResult
	 */
	@PostMapping("/create")
	public void create(@Valid MobileTask task, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return;
		}
		ServiceManager.taskService.save(task);
	}
}
