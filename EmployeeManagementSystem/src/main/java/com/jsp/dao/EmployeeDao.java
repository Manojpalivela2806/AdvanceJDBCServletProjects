package com.jsp.dao;

import java.util.List;

import com.jsp.model.EmployeeJ;

public interface EmployeeDao {
	
	List<EmployeeJ> getAllEmployees();
	
	List<EmployeeJ> getAllEmployeesByparamater(double i);
	
//	public EmployeeJ updateEmployee(int id);
	
	EmployeeJ getEmployeeById(int id);
	
	int updateEmployeeDetails(EmployeeJ employee);
	
	int deleteEmployee(int id);
	int addEmployee(EmployeeJ employee);
}
