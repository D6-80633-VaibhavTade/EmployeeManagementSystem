package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.mapper.EmployeeMapper;
import com.app.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor//to inject dependency using ctor based injection
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
	//Employee employee =	EmployeeMapper.mapToEmployee(employeeDto);
		Employee employee=mapper.map(employeeDto,Employee.class);
	
	Employee savedEmployee = employeeRepository.save(employee);
		
		
		return mapper.map(savedEmployee,EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return employeeRepository.findAll()
		                  .stream()
		                  .map(emp -> mapper.map(emp, EmployeeDto.class))
		                  .collect(Collectors.toList());
		
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		 Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
	        return optionalEmployee.orElse(null);
	}

	@Override
	public EmployeeDto getEmployeeByIdUsingDto(Long empId){//long can also be used) 
		Optional<Employee> employee =employeeRepository.findById(empId);
		Employee emp=employee.orElseThrow();
		System.out.println("in emp serviceimpl "+ employee);
		EmployeeDto employeeDto = mapper.map(emp, EmployeeDto.class);
		System.out.println("in emp serviceimpl "+ employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployeeById(EmployeeDto employeeDto) {
		Employee emp=employeeRepository.findById(employeeDto.getId()).orElseThrow();
		//Employee employee = mapper.map(employeeDto, Employee.class);
		
		//emp.setId(employeeDto.getId());
		emp.setFirstName(employeeDto.getFirstName());
		emp.setLastName(employeeDto.getLastName());
		emp.setEmail(employeeDto.getEmail());
	
		Employee savedEmployee = employeeRepository.save(emp);
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
	Employee employee =	employeeRepository.findById(employeeId).orElse(null);
	
	employee.setFirstName(updatedEmployee.getFirstName());
	employee.setLastName(updatedEmployee.getLastName());
	employee.setEmail(updatedEmployee.getEmail());
	
	Employee savedEmployee = employeeRepository.save(employee);
	
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployeeById(Long empId) {
	Employee employee =	employeeRepository.findById(empId).orElse(null);
	
	employeeRepository.deleteById(empId);
	
		
	}

	

}
