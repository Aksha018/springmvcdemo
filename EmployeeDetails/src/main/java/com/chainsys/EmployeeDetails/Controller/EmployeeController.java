package com.chainsys.EmployeeDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.EmployeeDetails.Dao.EmployeeDao;
import com.chainsys.EmployeeDetails.Model.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping("/addform")
	public String add() {
		return "/add-employee.jsp";
	}
	@GetMapping("addemployee")
	public String insertEmployee(@RequestParam("empId")int empId,@RequestParam("empName")String empName,@RequestParam("salary")float salary,@RequestParam("designation")String designation,Model model) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setDesignation(designation);
		
		int addemp = employeeDao.addEmployee(emp);
		List<Employee> employeeList = employeeDao.listEmployee();
		model.addAttribute(employeeList);
		return "/list-employee.jsp";
	}
	@GetMapping("/updateform")
	public String update() {
		return "/add-employee.jsp";
	}
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("empName")String empName,@RequestParam("salary")float salary,@RequestParam("designation")String designation,@RequestParam("empId")int empId,Model model) {
		Employee emp = new Employee();
		
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setDesignation(designation);
		emp.setEmpId(empId);
		
		int updateEmp = employeeDao.updateEmployee(emp);
		List<Employee> employeeList = employeeDao.listEmployee();
		model.addAttribute(employeeList);
		return "/list-employee.jsp";
		
}
	@GetMapping("/deleteform")
	public String delete() {
		return "/delete-employee.jsp";
	}	
	
	@GetMapping("delete")
	public String deleteEmployee(@RequestParam("empId")int empId,Model model) {
		int deleteEmp=employeeDao.deleteEmployee(empId);
		List<Employee> employeeList = employeeDao.listEmployee();
		model.addAttribute(employeeList);
		return "/list-employee.jsp";
		
	}
	@GetMapping("/findbyidform")
	public String findbyid() {
		return "/findby-empid.jsp";
	}	
	
	@GetMapping("findbyempid")
	public String findbyid(@RequestParam("empId")int empId,Model model) {
		Employee findbyempid=employeeDao.findByEmployeeId(empId);
		model.addAttribute("findbyempid", findbyempid);
		return "/list-employee.jsp";
		
	}
}
