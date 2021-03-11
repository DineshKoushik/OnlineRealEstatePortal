package com.au.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.model.Buyer;
import com.au.project.service.BuyerService;

@RestController
@RequestMapping("/api")
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@PostMapping(value = "/buy/{buyerId}/{propertyId}")
	public ResponseEntity<String> buy(@PathVariable(name = "buyerId") String buyerId, @PathVariable(name = "propertyId") String propertyId) {
		String p = buyerService.buy(buyerId, propertyId);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User Avaialable!", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/buy/get")
	public ResponseEntity<Object> getAllDetails() {
		List<Buyer> b = buyerService.getAllDetails();
		if (b.isEmpty()) {
			return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/buy/get/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") String id) {
		Buyer b = buyerService.getById(id);
		if (b == null) {
			return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}

}
