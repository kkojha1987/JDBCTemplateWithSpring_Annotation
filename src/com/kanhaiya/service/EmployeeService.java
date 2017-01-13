package com.kanhaiya.service;

import java.util.List;

import com.kanhaiya.model.Employee;

public interface EmployeeService {
	public abstract void addEmployee(Employee employee);
	public abstract Employee getEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
	public abstract void updateEmployeeEmailByid(String newEmail, int employeeId);
	public abstract List<Employee> getAllEmployee();
}
