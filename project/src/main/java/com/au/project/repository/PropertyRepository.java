package com.au.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.project.model.Property;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String>{

	@Query(value = "{'cost' : {$lte:?0}}")
	List<Property> getAllByCostLessThan(Long budget);

	@Query(value = "{'location.area':?0}")
	List<Property> getByLocality(String area);

	@Query(value = "{'cost' : {$gte:?0, $lte:?1}, 'location.area':?2, 'location.city':?3, 'propertyType':?4}")
	List<Property> search(Long from, Long to, String area, String city, String propertyType);

	@Query(value = "{'propertyId':?0}")
	Property getDetails(String propertyId);

}
