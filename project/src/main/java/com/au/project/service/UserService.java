package com.au.project.service;

import java.util.List;

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

}
