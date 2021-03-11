
/**
 * This is a service class, this extends functions of repository class.
 */
package com.au.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.au.project.model.Login;
import com.au.project.model.User;
import com.au.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public String createUser(User d) {

		User newd = userRepository.insert(d);
		return "User Created With Name " + newd.getName();
	}
	
	public List<User> checkUser(Login login) {
		User u = new User();
		u.setEmail(login.getEmailId());
		u.setPassword(login.getPassword());
		Example<User> ex = Example.of(u);
		return userRepository.findAll(ex);
	}

	public List<User> getAllDetails() {
		return userRepository.findAll();
	}

	public List<User> getByName(String name) {
		return userRepository.findByName(name);
	}

	public Long getCount() {
		return userRepository.count();
	}

	public User getById(String userId) {
		return userRepository.getDetails(userId);
	}

}
