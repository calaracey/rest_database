package com.example.connor.rest_database.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bson.types.ObjectId;
public class SpringLoggingHelper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void GetAllPeople(){
        logger.info("Fetching all people in database");
    }
    public void GetPersonById(ObjectId id){
        logger.info("Fetching person with id: {}",id);
    }
    public void CreatePerson(ObjectId id){
        logger.info("Creating new person with id: {}", id);
    }
    public void UpdatePerson(ObjectId id){
        logger.info("Updating person with id: {}",id);
    }
    public void DeletePerson(ObjectId id){
        logger.info("Deleting person with id: {}",id);
    }
}

