package com.springboot.datajpa.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.datajpa.rest.dao.UserInfoDAO;
import com.springboot.datajpa.rest.model.UserInfo;

@Service
public class UserService {
	@Autowired
	private UserInfoDAO userInfoDAO;

	public List<UserInfo> getAllUsers() {
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoDAO.findAll().forEach(userInfoList::add);
		return userInfoList;
	}

	public void addUser(UserInfo userInfo) {
		userInfoDAO.save(userInfo);
	}
}