package com.au.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.project.model.Buyer;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer, String>{

	@Query(value = "{'id':?0}")
	Buyer findDetails(String id);

}
