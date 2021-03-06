package com.au.project.property.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.au.project.model.Property;
import com.au.project.model.User;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String>, QuerydslPredicateExecutor<Property>{
	
	@Query(value = "{'cost' : {$lte:?0}}")
	List<User> getAllByCostLessThan(Long budget);
	
	@Query(value = "{address.area:?0}")
	List<User> getByLocality(String area);

}
