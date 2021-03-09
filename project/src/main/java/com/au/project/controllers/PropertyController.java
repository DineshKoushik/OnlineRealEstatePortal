package com.au.project.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.project.model.Property;
import com.au.project.service.PropertyService;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	// This is Property post method for the API Request
	@PostMapping(value = "/post//{id}")
	public ResponseEntity<String> propertyAdd(@PathVariable(name = "id") String id,
			@Valid @NotNull @RequestBody Property d) {
		try {
			String s = propertyService.propertyAdd(id, d);
			return new ResponseEntity<>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// This is Get All method for the API Request
	@GetMapping(value = "/get")
	public ResponseEntity<Object> getAllPropertyDetails() {
		List<Property> p = propertyService.getAllPropertyDetails();
		if (p.isEmpty()) {
			return new ResponseEntity<>("No Property available", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}

	}

	// This method fetches the details which has cost less than or equal to the
	// budget.
	@GetMapping(value = "/budget")
	public ResponseEntity<Object> getAllByCostLessThan(@RequestParam(name = "budget") Long budget) {
		List<Property> u = propertyService.getAllByCostLessThan(budget);
		if (u.isEmpty()) {
			return new ResponseEntity<>("No Property with cost less than " + budget, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}

	}

	// This is GetByLocality Method for the API Request
	@GetMapping(value = "/get/{area}")
	public ResponseEntity<Object> getByLocality(@PathVariable("area") String area) {
		List<Property> u = propertyService.getByLocality(area);
		if (u.isEmpty()) {
			return new ResponseEntity<>("No Property in the area " + area, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}

	}

	// Search filter with (propertyType, Location, Budget range{from, to})
	@GetMapping(value = "/get/{cost1}/{cost2}/{area}/{city}/{propertyType}")
	public ResponseEntity<Object> search(@PathVariable("cost1") Long cost1, @PathVariable("cost2") Long cost2,
			@PathVariable("area") String area, @PathVariable("city") String city,
			@PathVariable("propertyType") String propertyType) {
		List<Property> u = propertyService.search(cost1, cost2, area, city, propertyType);
		if (u.isEmpty()) {
			return new ResponseEntity<>("No Property available with the given filter", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}

	}

}
