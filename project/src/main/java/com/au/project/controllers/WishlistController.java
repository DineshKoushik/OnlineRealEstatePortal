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

import com.au.project.model.Wishlist;
import com.au.project.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
	
	@Autowired
	WishlistService wishlistService;
	
	@PostMapping(value = "/{userId}/{propertyId}")
	public ResponseEntity<String> addToWishlist(@PathVariable(name = "userId") String userId, @PathVariable(name = "propertyId") String propertyId) {
		String p = wishlistService.addToWishlist(userId, propertyId);
			return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<Object> getAllDetails() {
		List<Wishlist> b = wishlistService.getAllDetails();
		if (b.isEmpty()) {
			return new ResponseEntity<>("Wishlist is Empty!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") String id) {
		Wishlist b = wishlistService.getById(id);
		if (b == null) {
			return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
	}

}
