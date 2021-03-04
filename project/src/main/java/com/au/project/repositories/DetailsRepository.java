package com.au.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.project.model.details;

@Repository
public interface DetailsRepository extends MongoRepository<details, Long> {

}
