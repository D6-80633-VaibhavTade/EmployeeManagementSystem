package com.app.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping // to make this method Rest Api to save the employee
	//the data coming through the http request will be in JSON format . So to extract and convert it into
	//employeeDto java Object, use RequestBody annotation
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		System.out.println(employeeDto);
		EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
   public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
	  List<EmployeeDto> listEmployee = employeeService.getAllEmployee();
	return ResponseEntity.ok(listEmployee);
   }
	
	@GetMapping("/getEmployeeById/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId){
	         Employee employee =   employeeService.getEmployeeById(empId);
	         System.out.println("in get employee by id: " + empId);
	         System.out.println("in get employee by id: " + employee);
	         if (employee != null) {
	             return ResponseEntity.ok(employee);
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	}
	
	@GetMapping("/getEmployeeByIdUsingDto/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeByIdUsingEmpDto(@PathVariable("id") Long empId){
		System.out.println("in emp Controller "+empId);
		EmployeeDto employeeDto =employeeService.getEmployeeByIdUsingDto(empId);
		return ResponseEntity.ok(employeeDto);
		
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto employeeDto){
		EmployeeDto updatedEmployeeDto = employeeService.updateEmployeeById(employeeDto);
		return ResponseEntity.ok(updatedEmployeeDto);
	}
	
	
	@PutMapping("/updateEmployeeUsingId/{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeUsingId(@PathVariable("id") Long empId, @RequestBody EmployeeDto updatedEmployee){
	EmployeeDto employeeDto = employeeService.updateEmployee(empId, updatedEmployee);
	return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long empId){
		employeeService.deleteEmployeeById(empId);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
}
