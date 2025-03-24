package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

@RestController
@RequestMapping("/test")
public class SecurityController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/user")
	public String user() {
		return "User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Admin";
	}

	@GetMapping("/create")
	public String create(@RequestParam String username,
			@RequestParam String password) {
		
		return userService.create(username, password);
		
	}
}
