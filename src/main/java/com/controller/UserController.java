package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.service.UserServices;

@RestController
public class UserController {

	// userdao useer =new userDao
	// us

	// UserServi user = new userDao();

	@Autowired
	UserServices userServices;

	@PostMapping(value = "/user")
	public String addUser(@RequestBody UserBean userBean) {

		int res = userServices.addUser(userBean);
		if (res > 0) {
			return "record added..";
		}
		return "record not added..";

	}

	@GetMapping(value = "/user")
	public List<UserBean> getAllUsers(){
		
		
		return userServices.getAllUsers();
	}

}
