
/**
 * This is a service class, this extends functions of repository class.
 */
package com.au.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.au.project.model.User;
import com.au.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllDetails() {
		return userRepository.findAll();
	}

	public String CreateUser(User d) {

		User newd = userRepository.insert(d);
		return "User Created With Name " + newd.getName();
	}

	public List<User> getAllByExample(User user) {
		Example<User> e = Example.of(user);
		return userRepository.findAll(e);
	}

	public Long getCount() {
		return userRepository.count();
	}
	
	public List<User> getByName(String name) {
		return userRepository.findByName(name);
	}
	
	public List<User> getAllByCostLessThan(Long budget){
		return userRepository.getAllByCostLessThan(budget);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> getById(String id) {
		return userRepository.findById(id);
	}

}
