
/**
 *  This Class contains all Rest API Requests
 */

package com.au.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// This is Create method for the API Request
	@PostMapping(value = "/create")
	public ResponseEntity<?> createUser(@RequestBody User d) {
		try {
			String s = userService.CreateUser(d);
			return new ResponseEntity<String>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// This is Get All method for the API Request
	@GetMapping(value = "/get/all")
	public ResponseEntity<?> getAllDetails() {
		List<User> user = userService.getAllDetails();
		if (user.size() > 0) {
			return new ResponseEntity<List<User>>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User Avaialable!", HttpStatus.NOT_FOUND);
		}
	}

	// This is GetById method for the API Request
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<User> u = userService.getById(id);
		if (u.isPresent()) {
			return new ResponseEntity<User>(u.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable with id " + id, HttpStatus.NOT_FOUND);
		}
	}

	// This is GetByName method for the API Request
	@GetMapping(value = "/name")
	public ResponseEntity<?> getByName(@RequestParam(name = "name") String name) {
		List<User> u = userService.getByName(name);
		if (u.size() > 0) {
			return new ResponseEntity<List<User>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable with name " + name, HttpStatus.NOT_FOUND);
		}
	}

	// This is GetByEmail method for the API Request
	@GetMapping(value = "/email")
	public ResponseEntity<?> findByEmail(@RequestParam(name = "email") String email) {
		User u = userService.findByEmail(email);
		if (u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable with email " + email, HttpStatus.NOT_FOUND);
		}
	}

	// This is Generic Method for the API Request
	@GetMapping(value = "/get/Byexample")
	public ResponseEntity<?> getAllByExample(@RequestBody User user) {
		List<User> u = userService.getAllByExample(user);
		if (u.size() > 0) {
			return new ResponseEntity<List<User>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable!", HttpStatus.NOT_FOUND);
		}
	}

	// This is Get Count method for the API Request
	@GetMapping(value = "/get/count")
	public ResponseEntity<?> getCount() {
		Long num = userService.getCount();
		if (num != 0) {
			return new ResponseEntity<Long>(num, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Users list is empty", HttpStatus.NOT_FOUND);
		}
	}

}
