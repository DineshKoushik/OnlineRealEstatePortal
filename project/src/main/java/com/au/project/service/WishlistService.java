package com.au.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.project.model.Wishlist;
import com.au.project.repository.WishlistRepository;

@Service
public class WishlistService {
	
	@Autowired
	WishlistRepository wishlistRepository;

	public String addToWishlist(String userId, String propertyId) {
		Wishlist w = new Wishlist();
		
		w.setUserId(userId);
		w.setWishPropertyId(propertyId);
		
		wishlistRepository.save(w);
		
		return "Added to Wishlist!";
	}

	public List<Wishlist> getAllDetails() {
		return wishlistRepository.findAll();
	}

	public Wishlist getById(String id) {
		return wishlistRepository.getDetails(id);
	}

}
