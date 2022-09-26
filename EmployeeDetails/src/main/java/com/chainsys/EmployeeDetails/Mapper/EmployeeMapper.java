package com.chainsys.EmployeeDetails.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.EmployeeDetails.Model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum)throws SQLException{
		
		int empId = rs.getInt(1);
		String empName = rs.getString(2);
		float salary = rs.getFloat(3);
		String designation = rs.getString(4);
		
		Employee employee = new Employee();
		
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setSalary(salary);
		employee.setDesignation(designation);
		
		return employee;
	}
	

}
