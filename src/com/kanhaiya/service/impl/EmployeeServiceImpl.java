package com.kanhaiya.service.impl;

import java.util.List;

import com.kanhaiya.dao.EmployeeDao;
import com.kanhaiya.model.Employee;
import com.kanhaiya.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public void addEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
	
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		employeeDao.deleteEmployeeById(employeeId);
		
	}

	@Override
	public void updateEmployeeEmailByid(String newEmail, int employeeId) {
		employeeDao.updateEmployeeEmailByid(newEmail, employeeId);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeDao.getAllEmployee();
	}

}
