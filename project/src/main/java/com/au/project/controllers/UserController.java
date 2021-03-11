
/**
 *  This Class contains all Rest API Requests
 */

package com.au.project.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.model.Login;
import com.au.project.model.User;
import com.au.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	// This is Create method for the API Request
	@PostMapping(value = "/create")
	public ResponseEntity<String> createUser(@Valid @NotNull @RequestBody User user) {
		try {
			String s = userService.createUser(user);
			return new ResponseEntity<>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Login Method
	@PostMapping(value = "/login")
	public ResponseEntity<Object> checkUser(@RequestBody Login login) {
		List<User> tempUser = userService.checkUser(login);
		if (tempUser.isEmpty()) {
			return new ResponseEntity<>("Enter valid details", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Login Successfull!", HttpStatus.OK);
		}
	}

	// This is Get All method for the API Request
	@GetMapping(value = "/get")
	public ResponseEntity<Object> getAllDetails() {
		List<User> user = userService.getAllDetails();
		if (user.isEmpty()) {
			return new ResponseEntity<>("No user found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	// This is GetByName method for the API Request
	@GetMapping(value = "/get/{userId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "userId") String userId) {
		User u = userService.getById(userId);
		if (u == null) {
			return new ResponseEntity<>("No User avaialable with id = " + userId, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}

	// This is Get Count method for the API Request
	@GetMapping(value = "/get/count")
	public ResponseEntity<Object> getCount() {
		Long num = userService.getCount();
		if (num != 0) {
			return new ResponseEntity<>("No User avaialable", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(num, HttpStatus.OK);
		}

	}

}
