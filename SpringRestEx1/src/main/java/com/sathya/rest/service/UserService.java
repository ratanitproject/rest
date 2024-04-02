package com.sathya.rest.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.rest.entity.User;
import com.sathya.rest.model.LoginRequest;
import com.sathya.rest.model.UserRegistrationDetails;
import com.sathya.rest.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {
	
		@Autowired
	    private UserRepository userRepository;

	    public boolean registerUser(UserRegistrationDetails userDetails) {
	        User user = new User();
	        user.setUsername(userDetails.getUsername());
	        user.setPassword(userDetails.getPassword());
	        user.setEmail(userDetails.getEmail());
	        user.setMobile(userDetails.getMobile());
	        user.setCreateAt(LocalDateTime.now());
	        user.setCreateBy(System.getProperty("user.name"));
	        userRepository.save(user);
	        
	        return true; // or false based on registration success/failure
	    }

		public User loginUser(@Valid LoginRequest loginRequest) {
			return userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
			
			
		}
}
