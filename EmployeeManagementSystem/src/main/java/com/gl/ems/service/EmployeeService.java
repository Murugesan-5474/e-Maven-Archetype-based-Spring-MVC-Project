package com.gl.ems.service;

import java.util.List;

import com.gl.ems.model.Employee;

public interface EmployeeService {
	void addEmployee(Employee e);
	List<Employee> getAllEmployees();
	void deleteById(int eid);
	void updateEmployee(Employee e);
	Employee getEmployeeById(int eid);
}
