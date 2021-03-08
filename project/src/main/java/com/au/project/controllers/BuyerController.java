package com.au.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.service.BuyerService;

@RestController
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@GetMapping(value = "/buy/{propertyId}")
	public ResponseEntity<?> Buy(@PathVariable(name = "propertyId") String propertyId) {
		String p = buyerService.Buy(propertyId);
		if (p != null) {
			return new ResponseEntity<String>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User Avaialable!", HttpStatus.NOT_FOUND);
		}
	}

}
