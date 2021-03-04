package com.au.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "details")
public class details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String userType;
	private Long budget;
	private Long cost;
	private Long numberOfAcres;
	private String PropertyType;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Long getNumberOfAcres() {
		return numberOfAcres;
	}

	public void setNumberOfAcres(Long numberOfAcres) {
		this.numberOfAcres = numberOfAcres;
	}

	public String getPropertyType() {
		return PropertyType;
	}

	public void setPropertyType(String propertyType) {
		PropertyType = propertyType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public details(long id, String name, String email, String password, String mobileNumber, String userType,
			Long budget, Long cost, Long numberOfAcres, String propertyType, String location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
		this.budget = budget;
		this.cost = cost;
		this.numberOfAcres = numberOfAcres;
		PropertyType = propertyType;
		this.location = location;
	}

	public details() {
		super();
	}

}
