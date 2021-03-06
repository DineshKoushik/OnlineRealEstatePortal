package com.au.project.controllers;

import java.util.List;

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
import com.au.project.model.User;
import com.au.project.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	// This is Property post method for the API Request
	@PostMapping(value = "/post")
	public ResponseEntity<?> PropertyAdd(@RequestBody Property d) {
		try {
			String s = propertyService.PropertyAdd(d);
			return new ResponseEntity<String>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// This method fetches the details which has cost less than or equal to the
	// budget.
	@GetMapping(value = "/budget")
	public ResponseEntity<?> getAllByCostLessThan(@RequestParam(name = "budget") Long budget) {
		List<User> u = propertyService.getAllByCostLessThan(budget);
		if (u.size() > 0) {
			return new ResponseEntity<List<User>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable with budget less than equal to " + budget,
					HttpStatus.NOT_FOUND);
		}
	}

	// This is GetByLocality Method for the API Request
	@GetMapping(value = "/get/{area}")
	public ResponseEntity<?> getByLocality(@PathVariable("area") String area) {
		List<User> u = propertyService.getByLocality(area);
		if (u.size() > 0) {
			return new ResponseEntity<List<User>>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No User avaialable in the given area!", HttpStatus.NOT_FOUND);
		}
	}

}
