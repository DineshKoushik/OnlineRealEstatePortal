package com.au.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.model.details;
import com.au.project.repositories.DetailsRepository;

@RestController
@RequestMapping("/user")
public class DetailsController {

	@Autowired
	public DetailsRepository detailsrepo;

	@GetMapping(value = "/all")
	public List<details> getAllDetails() {
		return detailsrepo.findAll();
	}

	@PostMapping(value = "/create")
	public String createUser(@RequestBody details d) {
		
		details newd = detailsrepo.insert(d);
		return "User Created With Name " + newd.getName();
	}

}
