package com.au.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.project.model.Property;
import com.au.project.model.User;
import com.au.project.property.repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;

	public String PropertyAdd(Property d) {
		propertyRepository.insert(d);
		return "New property is added";
	}
	
	public List<User> getByLocality(String area) {
		return propertyRepository.getByLocality(area);
	}
	
	public List<User> getAllByCostLessThan(Long budget) {
		return propertyRepository.getAllByCostLessThan(budget);
	}

}
