package com.bootdo.mobile.system.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.helper.ServiceManager;
import com.bootdo.mobile.system.domain.MobileUser;

@RestController
@RequestMapping(value = "/mobile/user")
public class MobileUserController {

	@GetMapping("/findById")
	public MobileUser findById(Long id) {
		return ServiceManager.userService.findById(id);
	}

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@Valid MobileUser user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return;
		}
		ServiceManager.userService.save(user);
	}

}
