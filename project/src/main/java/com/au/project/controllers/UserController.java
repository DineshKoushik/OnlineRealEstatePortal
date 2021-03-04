package com.au.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.model.User;
import com.au.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/all")
	public List<User> getAllDetails() {
		return userService.getAllDetails();
	}

	@PostMapping(value = "/create")
	public String createUser(@RequestBody User d) {
		return userService.CreateUser(d);
	}

	@GetMapping(value = "/example")
	public List<User> getAllByExample(@RequestBody User user){
		return userService.getAllByExample(user);
	}
	
	@GetMapping(value = "/count")
	public Long getCount() {
		return userService.getCount();
	}
	
	@GetMapping(value = "/name")
	public List<User> getByName(@RequestParam(name = "name") String name) {
		return userService.getByName(name);
	}
	
	@GetMapping(value = "/budget")
	public List<User> getAllByCostLessThan(@RequestParam(name = "budget") Long budget) {
		return userService.getAllByCostLessThan(budget);
	}
}
