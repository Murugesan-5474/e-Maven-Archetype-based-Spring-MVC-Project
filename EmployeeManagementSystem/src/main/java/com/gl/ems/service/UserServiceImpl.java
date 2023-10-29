package com.gl.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.dao.UserDAO;
import com.gl.ems.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;
	
	@Override
	public void addUser(User u) {
	
		dao.addUser(u);
	}

	@Override
	public boolean validateUser(User u) {
		
		return dao.validateUser(u);
	}

}
