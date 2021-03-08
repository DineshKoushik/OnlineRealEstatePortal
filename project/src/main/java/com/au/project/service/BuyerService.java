package com.au.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.project.model.Buyer;
import com.au.project.model.Property;
import com.au.project.Repository.BuyerRepository;
import com.au.project.Repository.PropertyRepository;

@Service
public class BuyerService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	public String Buy(String propertyId) {
		
		Optional<Property> opt = propertyRepository.findById(propertyId);
		Property property = opt.get();
		
		Buyer buyer = new Buyer();
		
		buyer.setUserId(property.getUserId());
		buyer.setPropertyId(property.getPropertyId());
		buyer.setPropertyType(property.getPropertyType());
		buyer.setNumberOfAcres(property.getNumberOfAcres());
		buyer.setCost(property.getCost());
		buyer.setLocation(property.getLocation());
		
		buyerRepository.save(buyer);
		
		propertyService.deleteProperty(propertyId);
		
		return "Successfull";
		
	}

}
