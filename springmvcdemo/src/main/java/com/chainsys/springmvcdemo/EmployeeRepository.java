package com.chainsys.springmvcdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
	public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
		
	EmployeeModel findById(int id);

	EmployeeModel save(EmployeeModel emp); 
		
		void deleteById(int id);

		List<EmployeeModel> findAll();

		EmployeeModel findByEmailAndPassword(String email,String password);

}
