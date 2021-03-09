package com.au.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "MY_SEQ")
	private String propertyId;
	private String userId;
	@NotNull(message = "propertyType cannot be null")
	private String propertyType;
	@NotNull(message = "numberOfAcres cannot be null")
	private Long numberOfAcres;
	@NotNull(message = "Cost cannot be null")
	private Long cost;
	private Location location;

	public Property() {
		super();
	}

	public Property(String propertyId, String propertyType,
			@NotNull(message = "numberOfAcres cannot be null") Long numberOfAcres,
			@NotNull(message = "Cost cannot be null") Long cost, Location location, String userId) {
		super();
		this.propertyId = propertyId;
		this.propertyType = propertyType;
		this.numberOfAcres = numberOfAcres;
		this.cost = cost;
		this.location = location;
		this.userId = userId;
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