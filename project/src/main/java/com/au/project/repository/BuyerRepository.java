package com.au.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.project.model.Buyer;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer, String>{

}
