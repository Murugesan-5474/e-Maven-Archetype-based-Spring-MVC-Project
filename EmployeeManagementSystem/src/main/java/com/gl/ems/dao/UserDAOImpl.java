package com.gl.ems.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.ems.model.User;



@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sf;
	Session session;
	
	public UserDAOImpl(SessionFactory sf) {
		
		this.sf = sf;
		this.session=sf.openSession();
	}
	@Override
	@Transactional
	public void addUser(User u) {
		Transaction tx=session.beginTransaction();
		session.save(u);
		tx.commit();
		
	}
	@Override
	public boolean validateUser(User u) {
	List<User> list=session.createQuery("from User").list();
	boolean flag=false;
	
	for(User user:list)
	{
		if (user.getUsername().equals(u.getUsername()))
			if (user.getPassword().equals(u.getPassword())) {
				flag= true;
				break;
			}
	}
	
	return flag;
	}
}