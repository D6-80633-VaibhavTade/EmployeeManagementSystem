package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	

	List<EmployeeDto> getAllEmployee();



	Employee getEmployeeById(Long empId);



	EmployeeDto getEmployeeByIdUsingDto(Long empId);



	EmployeeDto updateEmployeeById(EmployeeDto employeeDto);
 
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);



	void deleteEmployeeById(Long empId);
	

}
