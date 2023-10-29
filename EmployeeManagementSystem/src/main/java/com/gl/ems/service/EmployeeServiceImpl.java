package com.gl.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.dao.EmployeeDAO;
import com.gl.ems.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDAO dao;
	
	@Override
	public void addEmployee(Employee e) {
		
		dao.addEmployee(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	@Override
	public void deleteById(int eid) {
		dao.deleteById(eid);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		dao.updateEmployee(e);
		
	}

	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(eid);
	}

}

