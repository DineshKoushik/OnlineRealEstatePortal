package com.au.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Buyer")
public class Buyer {

	@Id
	private String buyerId;
	private String userId;
	private String propertyId;
	private String propertyType;
	private Long numberOfAcres;
	private Long cost;
	private Location location;

	public Buyer() {
		super();
	}

	public Buyer(String buyerId, String userId, String propertyId, String propertyType, Long numberOfAcres, Long cost,
			Location location) {
		super();
		this.buyerId = buyerId;
		this.userId = userId;
		this.propertyId = propertyId;
		this.propertyType = propertyType;
		this.numberOfAcres = numberOfAcres;
		this.cost = cost;
		this.location = location;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Long getNumberOfAcres() {
		return numberOfAcres;
	}

	public void setNumberOfAcres(Long numberOfAcres) {
		this.numberOfAcres = numberOfAcres;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
