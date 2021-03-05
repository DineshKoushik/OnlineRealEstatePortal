
/**
 * This Class is used to connect to database.
 */

package com.au.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.project.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	
	List<User> findByName(String name);
	
	@Query(value = "{'cost' : {$lte:?0}}")
	List<User> getAllByCostLessThan(Long budget);
	
	User findByEmail(String email);

	Optional<User> findById(String id);
	
	
}
