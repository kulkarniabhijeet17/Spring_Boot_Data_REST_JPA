package com.springboot.datajpa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.datajpa.rest.model.UserInfo;
import com.springboot.datajpa.rest.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/getUser")
	public List<UserInfo> getAllUser() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody UserInfo userInfo) {
		userService.addUser(userInfo);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public void addUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserID("Abhijeet24");
		userInfo.setFirstName("Abhijeet");
		userInfo.setLastName("Kulkarni");
		userInfo.setMiddleInitial("R");
		userInfo.setDob("27/11/1989");
		userInfo.setEmailID("kulkarniabhijeet17@gmail.com");

		userService.addUser(userInfo);
	}
}