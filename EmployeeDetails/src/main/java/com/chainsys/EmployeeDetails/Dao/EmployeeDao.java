package com.chainsys.EmployeeDetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.EmployeeDetails.Mapper.EmployeeMapper;
import com.chainsys.EmployeeDetails.Model.Employee;

@Repository
public class EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public int addEmployee(Employee employee) {
    	String query = "insert into EMPDETAILS(EMP_ID,EMP_NAME,SALARY,DESIGNATION) values(?,?,?,?)";
        int details=0;
        Object[] empdetails = {employee.getEmpId(),employee.getEmpName(),employee.getSalary(),employee.getDesignation()};
        details = jdbcTemplate.update(query,empdetails);
        return details;
    }
   public List<Employee>listEmployee(){
	   String query = "select EMP_ID,EMP_NAME,SALARY,DESIGNATION from EMPDETAILS";
	   List<Employee> listEmployee = null;
	   listEmployee = jdbcTemplate.query(query, new EmployeeMapper());
	   return listEmployee;
	   
   }
   public int updateEmployee(Employee employee) {
	   	String query = "update EMPDETAILS set EMP_NAME=?,SALARY=?,DESIGNATION=? where EMP_ID=?";
	   	int details=0;
	   	Object[] empdetails= {employee.getEmpName(),employee.getSalary(),employee.getDesignation(),employee.getEmpId()};
	   	details = jdbcTemplate.update(query,empdetails);
	   	return details;
   }
   public int deleteEmployee(int empId) {
	   String query = "delete from EMPDETAILS where EMP_ID=?";
	   int details=0;
	   details=jdbcTemplate.update(query,empId);
	   return details;
   }
    public Employee findByEmployeeId(int empId) {
    	String query = "select EMP_ID,EMP_NAME,SALARY,DESIGNATION from EMPDETAILS where EMP_ID=?";
    	Employee findByEmployeeId=null;
    	findByEmployeeId = jdbcTemplate.queryForObject(query, new EmployeeMapper(), empId);
    	return findByEmployeeId;
    	
    }
	
}
