package com.sathya.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.entity.User;
import com.sathya.rest.model.LoginRequest;
import com.sathya.rest.model.Response;
import com.sathya.rest.model.UserRegistrationDetails;
import com.sathya.rest.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
    private UserService userService;
		
	 	@PostMapping("/register")
	    public ResponseEntity<Response> registerUser(@Valid @RequestBody UserRegistrationDetails userDetails) {
	        boolean isRegistered = userService.registerUser(userDetails);
	        
	        if (isRegistered) {
	        	Response response = new Response();
	        	response.setMessage("User registered successfully"); 
	        	response.setStatusCode(HttpStatus.CREATED.value());
	            return ResponseEntity.status(HttpStatus.CREATED)
	            					  .body(response);
	        }else{
	        	Response response = new Response();
	        	response.setMessage("Failed to register user"); 
	        	response.setStatusCode(HttpStatus.BAD_REQUEST.value());
	        
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
	            					  .body(response);
	        }
	    }
	 	
	 	
	 	 @PostMapping("/login")
	     public ResponseEntity<Response> login(@Valid @RequestBody LoginRequest loginRequest) {
	        
	 		 User user = userService.loginUser(loginRequest);
	 		 
	 		 if (user!=null) {
		        	Response response = new Response();
		        	response.setMessage("User Login successfully"); 
		        	response.setStatusCode(HttpStatus.OK.value());
		        	
		            return ResponseEntity.status(HttpStatus.OK)
		            					  .body(response);
		        }else{
		        	Response response = new Response();
		        	response.setMessage("Login Fail check the credentials"); 
		        	response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		        
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value())
		            					  .body(response);
		        }
	     }	 	
}