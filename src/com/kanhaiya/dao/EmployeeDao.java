package com.kanhaiya.dao;

import java.util.List;

import com.kanhaiya.model.Employee;

public interface EmployeeDao {

	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
	public abstract void updateEmployeeEmailByid(String newEmail, int employeeId);
	public abstract List<Employee> getAllEmployee();
	
	
}
