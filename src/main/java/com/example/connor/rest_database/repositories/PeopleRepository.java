package com.example.connor.rest_database.repositories;

import com.example.connor.rest_database.models.People;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<People, String> {
  People findBy_id(ObjectId _id);
}
