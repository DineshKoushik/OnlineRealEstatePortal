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
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	// This is Property post method for the API Request
	@PostMapping(value = "/{id}/post")
	public ResponseEntity<?> PropertyAdd(@PathVariable(name = "id") String id,
			@Valid @NotNull @RequestBody Property d) {
		try {
			String s = propertyService.PropertyAdd(id, d);
			return new ResponseEntity<String>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// This is Get All method for the API Request
	@GetMapping(value = "/get")
	public ResponseEntity<?> getAllPropertyDetails() {
		List<Property> p = propertyService.getAllPropertyDetails();
		if (p.size() > 0) {
			return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User Avaialable!", HttpStatus.NOT_FOUND);
		}
	}

	// This method fetches the details which has cost less than or equal to the
	// budget.
	@GetMapping(value = "/budget")
	public ResponseEntity<?> getAllByCostLessThan(@RequestParam(name = "budget") Long budget) {
		List<Property> u = propertyService.getAllByCostLessThan(budget);
		if (u.size() > 0) {
			return new ResponseEntity<List<Property>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No Property avaialable with budget less than equal to " + budget,
					HttpStatus.NOT_FOUND);
		}
	}

	// This is GetByLocality Method for the API Request
	@GetMapping(value = "/get/{area}")
	public ResponseEntity<?> getByLocality(@PathVariable("area") String area) {
		List<Property> u = propertyService.getByLocality(area);
		if (u.size() > 0) {
			return new ResponseEntity<List<Property>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No Property avaialable in the given area!", HttpStatus.NOT_FOUND);
		}
	}

	// Search filter with (propertyType, Location, Budget range{from, to})
	@GetMapping(value = "/get/{cost1}/{cost2}/{area}/{city}/{propertyType}")
	public ResponseEntity<?> Search(@PathVariable("cost1") Long cost1, @PathVariable("cost2") Long cost2,
			@PathVariable("area") String area, @PathVariable("city") String city,
			@PathVariable("propertyType") String propertyType) {
		List<Property> u = propertyService.Search(cost1, cost2, area, city, propertyType);
		if (u.size() > 0) {
			return new ResponseEntity<List<Property>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No Property avaialable in the given area!", HttpStatus.NOT_FOUND);
		}
	}

}
