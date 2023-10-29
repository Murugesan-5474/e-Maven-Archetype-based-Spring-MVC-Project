package com.gl.ems.dao;

import com.gl.ems.model.User;

public interface UserDAO {

	void addUser(User u);
	boolean validateUser(User u);
}
