package com.au.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.project.model.Wishlist;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String>{

}
