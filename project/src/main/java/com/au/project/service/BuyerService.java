package com.au.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.project.model.Buyer;
import com.au.project.model.Property;
import com.au.project.repository.BuyerRepository;
import com.au.project.repository.PropertyRepository;

@Service
public class BuyerService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	public String buy(String buyerId, String propertyId) {
		
		Optional<Property> opt = propertyRepository.findById(propertyId);
		
		if(opt.isPresent()) {
			
			Property property = opt.get();
			
			Buyer buyer = new Buyer();
			
			buyer.setBuyerId(buyerId);
			buyer.setSellerId(property.getUserId());
			buyer.setpId(propertyId);
			buyer.setPtype(property.getPropertyType());
			buyer.setNoofAcres(property.getNumberOfAcres());
			buyer.setPropertyCost(property.getCost());
			buyer.setPropertyLocation(property.getLocation());
			
			buyerRepository.save(buyer);
			
			propertyService.deleteProperty(propertyId);
			
			return "Successfull";
			
		} else {
			return "No such property available";
		}
		
		
	}

	public List<Buyer> getAllDetails() {
		return buyerRepository.findAll();
	}

	public Buyer getById(String id) {
		return buyerRepository.findDetails(id);
	}

}
