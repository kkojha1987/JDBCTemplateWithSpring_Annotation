package com.kanhaiya.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kanhaiya.dao.EmployeeDao;
import com.kanhaiya.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	//private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/*
	@Override
	public void createEmployee(Employee employee)  {
		Connection conn=null;
        PreparedStatement ps=null;
		
		try {
			conn=dataSource.getConnection();
			String sql="INSERT INTO employee_table(employee_name,email, gender,salary) VALUES(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getGender());
			ps.setDouble(4, employee.getSalary());
			
			int executeUpdate=ps.executeUpdate();
			if(executeUpdate>0)
			System.out.println(" row inserted");
			else
				System.out.println("not inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}*/

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql="SELECT * FROM employee_table WHERE employee_id=?";
		Employee employee =jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {

String sql="delete from employee_table where employee_id=?";
int update=jdbcTemplate.update(sql, employeeId);
if(update>0)
{
	System.out.println("Deleted");
}
	}

	@Override
	public void updateEmployeeEmailByid(String newEmail, int employeeId) {

		String sql="update employee_table set email=? where employee_id=?";
		int update=jdbcTemplate.update(sql, newEmail,employeeId);
		if(update>0) 
			System.out.println("Email updated");
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql="SELECT * FROM employee_table";
		
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	@Override
	public void createEmployee(Employee employee) {
		//String sql="INSERT INTO employee_table(employee_name,email, gender,salary) VALUES(?,?,?,?)";
		//int update=jdbcTemplate.update(sql, new Object[]{employee.getEmployeeName(), employee.getEmail(), employee.getGender(), employee.getSalary()});
		int update=jdbcTemplate.update("INSERT INTO employee_table(employee_name,email, gender,salary) VALUES(?,?,?,?)", employee.getEmployeeName(), employee.getEmail(), employee.getGender(), employee.getSalary());
		if(update>0)
			System.out.println(" row inserted");
			else
				System.out.println("not inserted");
	}

}
