package com.au.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Buyer")
public class Buyer {

	@Id
	private String id;
	private String buyerId;
	private String sellerId;
	private String pId;
	private String ptype;
	private Long noofAcres;
	private Long propertyCost;
	private Location propertyLocation;

	public Buyer() {
		super();
	}

	public Buyer(String buyerId, String sellerId, String pId, String ptype, Long noofAcres, Long propertyCost,
			Location propertyLocation) {
		super();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.pId = pId;
		this.ptype = ptype;
		this.noofAcres = noofAcres;
		this.propertyCost = propertyCost;
		this.propertyLocation = propertyLocation;
	}
	
	public String getId() {
		return id;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Long getNoofAcres() {
		return noofAcres;
	}

	public void setNoofAcres(Long noofAcres) {
		this.noofAcres = noofAcres;
	}

	public Long getPropertyCost() {
		return propertyCost;
	}

	public void setPropertyCost(Long propertyCost) {
		this.propertyCost = propertyCost;
	}

	public Location getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Location propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

}
