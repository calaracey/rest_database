/*
PeopleRepository.java
Description: database query methods
*/

package com.example.connor.rest_database.repositories;
import java.util.List;
import com.example.connor.rest_database.models.People;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<People, String> {
	public People findBy_id(ObjectId _id);
	public List<People> findByfirstName(String firstName);
	public List<People> readByfirstNameRegex(String firstName);
	public List<People> findByAddressIsNotNull();
}
