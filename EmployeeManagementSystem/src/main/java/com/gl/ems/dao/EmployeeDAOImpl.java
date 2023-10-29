package com.gl.ems.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.ems.model.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sf;
	Session session;
	
	
	public EmployeeDAOImpl(SessionFactory sf) {
		
		this.sf = sf;
		this.session=sf.openSession();
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		Transaction tx=session.beginTransaction();
		
		session.save(e);
		System.out.println(e);
		tx.commit();
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return session.createQuery("from Employee").list();
	}

	@Override
	@Transactional
	public void deleteById(int eid) {
		Transaction tx=session.beginTransaction();
		Employee e=session.get(Employee.class,eid);
		session.delete(e);
		tx.commit();
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		session=sf.openSession();
		session.saveOrUpdate(e);
		
	}

	@Override
	public Employee getEmployeeById(int eid) {
		
		return session.get(Employee.class,eid);
	}

}
