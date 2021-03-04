package com.au.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.project.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
