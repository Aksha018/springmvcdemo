package com.chainsys.springmvcdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
	
	@Autowired 
	EmployeeRepository employeeRepository;
	
	public List<EmployeeModel> getEmployee() {
		return employeeRepository.findAll();
		
	}

	public EmployeeModel save(EmployeeModel per) {
		return employeeRepository.save(per);
	}

	public EmployeeModel findByEmployeeId(int id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}
	public EmployeeModel getEmailAndPassword(String email,String password) {
        return employeeRepository.findByEmailAndPassword(email, password);
	}

}
