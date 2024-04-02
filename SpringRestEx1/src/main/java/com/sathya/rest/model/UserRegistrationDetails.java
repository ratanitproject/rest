package com.sathya.rest.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDetails {
	 @NotBlank(message = "Username is required")
	 private String username;
	
	 @NotBlank(message = "Password is required")
	 @Size(min = 6, message = "Password must be at least 6 characters long")
	 private String password;
	 
	 @Email(message = "Invalid email address")
	 @NotBlank(message = "Email is required") 
	 private String email;
	 
	 
	 @Pattern(regexp = "[0-9]{10}", message = "Invalid mobile number")
	 @NotBlank(message = "Mobile number is required")
	 private String mobile;
}








