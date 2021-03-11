
/**
 * This Class is used to connect to database.
 */

package com.au.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.project.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByName(String name);

	@Query(value = "{'userId':?0}")
	User getDetails(String userId);
	

}
