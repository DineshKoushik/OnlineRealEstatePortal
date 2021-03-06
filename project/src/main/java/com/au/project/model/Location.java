package com.au.project.model;

import javax.validation.constraints.NotNull;

public class Location {

	@NotNull(message = "Area cannot be null")
	private String area;
	@NotNull(message = "City cannot be null")
	private String city;

	public Location() {
		super();
	}

	public Location(String area, String city) {
		super();
		this.area = area;
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
