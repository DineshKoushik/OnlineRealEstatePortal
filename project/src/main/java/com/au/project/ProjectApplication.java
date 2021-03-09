package com.au.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.au.project.repository.BuyerRepository;
import com.au.project.repository.PropertyRepository;
import com.au.project.repository.UserRepository;
import com.au.project.repository.WishlistRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ProjectApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Not required
		
	}

}
