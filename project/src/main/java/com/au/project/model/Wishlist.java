package com.au.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Wishlist")
public class Wishlist {

	@Id
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String userId;
	private String wishPropertyId;

	public Wishlist() {
		super();
	}

	public Wishlist(String userId, String wishPropertyId) {
		super();
		this.userId = userId;
		this.wishPropertyId = wishPropertyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String wishlistId) {
		this.userId = wishlistId;
	}

	public String getWishPropertyId() {
		return wishPropertyId;
	}

	public void setWishPropertyId(String wishPropertyId) {
		this.wishPropertyId = wishPropertyId;
	}

}
