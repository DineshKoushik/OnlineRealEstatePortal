
/**
 * This Class is used to connect to database.
 */

package com.au.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.project.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByName(String name);

	Optional<User> findById(String id);

	User findByEmail(String email);

}
