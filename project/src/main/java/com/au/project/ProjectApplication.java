package com.au.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.au.project.Repository.BuyerRepository;
import com.au.project.Repository.PropertyRepository;
import com.au.project.Repository.UserRepository;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
