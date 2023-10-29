package com.gl.ems.service;

import com.gl.ems.model.User;

public interface UserService {

	void addUser(User u);
	boolean validateUser(User u);
}
