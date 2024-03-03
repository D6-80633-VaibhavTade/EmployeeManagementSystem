package com.app.mapper;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {//this method will
		                                                           //map employee with employeeDto
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getPassword()
		      );
				
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {//this method will
                                                                  //map employeeDto with employee
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getPassword()
				
				);
				
	}

}
