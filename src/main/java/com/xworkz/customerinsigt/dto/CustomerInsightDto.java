package com.xworkz.customerinsigt.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInsightDto {
	
	private int id;
	
	@NotBlank(message="Data should not be null")
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String dateOfBirth;
	private String gender;
	private int otp;

}
