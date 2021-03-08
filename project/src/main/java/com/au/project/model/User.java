
/**
 * This is a model class, to initialize the entities for the project.
 */
package com.au.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "MY_SEQ")
	private String userId;
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 40)
	private String name;
	@NotNull(message = "Email cannot be null")
	@Size(min = 3, max = 40)
	private String email;
	@NotNull(message = "Password cannot be null")
	@Size(min = 8)
	private String password;
	@Size(min = 10, max = 10)
	private String mobileNumber;
	@NotNull(message = "UserType cannot be null")
	private String userType;  // Buyer/Owner, Agent, Builder

	public User() {
		super();
	}

	public User(String name, String email, String password, String mobileNumber, String userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
	}

	public String getId() {
		return userId;
	}

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

}
