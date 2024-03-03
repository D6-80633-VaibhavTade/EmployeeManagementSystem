package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	//@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	
	private String email; 
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	//@JsonIgnore//JsonIgnore can also be used
	private String password;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
