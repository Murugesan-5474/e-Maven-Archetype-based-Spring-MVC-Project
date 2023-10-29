package com.gl.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int empId;
String empName;
String designation;
int salary;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public Employee() {
	super();
	
}
public Employee(int empId, String empName, String designation, int salary) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.designation = designation;
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", salary=" + salary
		+ "]";
}

}
