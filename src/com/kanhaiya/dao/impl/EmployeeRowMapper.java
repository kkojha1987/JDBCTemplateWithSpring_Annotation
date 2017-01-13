package com.kanhaiya.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kanhaiya.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>
{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Employee employee=new Employee();
		employee.setEmail(rs.getString("email"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setGender(rs.getString("gender"));
		employee.setSalary(rs.getDouble("salary"));
		employee.setEmployeeId(rs.getInt("employee_id"));
		return employee;
	}

}
