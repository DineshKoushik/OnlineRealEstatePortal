package com.au.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.project.model.Property;
import com.au.project.repository.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
	PropertyRepository propertyRepository;

	public String propertyAdd(String id, Property d) {
		d.setUserId(id);
		propertyRepository.insert(d);
		return "New property is added";
	}

	public List<Property> getAllPropertyDetails() {
		return propertyRepository.findAll();
	}

	public List<Property> getAllByCostLessThan(Long budget) {
		return propertyRepository.getAllByCostLessThan(budget);
	}

	public List<Property> getByLocality(String area) {
		return propertyRepository.getByLocality(area);
	}

	public List<Property> search(Long cost1, Long cost2, String area, String city, String propertyType) {
		return propertyRepository.search(cost1, cost2, area, city, propertyType);
	}
	
	public void deleteProperty(String propertyId) {
		propertyRepository.deleteById(propertyId);
	}

}
