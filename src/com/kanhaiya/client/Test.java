package com.kanhaiya.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kanhaiya.model.Employee;
import com.kanhaiya.service.EmployeeService;
import com.kanhaiya.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
EmployeeService empService=context.getBean("employeeService", EmployeeServiceImpl.class);
//createEmployee(empService);
//getEmployeeServiceById(empService);

List<Employee> list=empService.getAllEmployee();
for(Employee emp : list)
{
	System.out.println(emp.getEmployeeId()+"\t" +emp.getEmployeeName());
}
context.close();
	}

	public static void getEmployeeServiceById(EmployeeService empService) {
		Employee employee= empService.getEmployeeById(3);
		System.out.println(employee.getEmployeeId()+"\t"+ employee.getEmployeeName());
	}

	public static void createEmployee(EmployeeService empService) {
		Employee employee=new Employee();
		employee.setEmployeeName("Siva");
		employee.setEmail("Shiva@gmail.com");
		employee.setGender("Male");
		employee.setSalary(50001.0);
		empService.addEmployee(employee);
	}

}
