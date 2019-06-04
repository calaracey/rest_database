/*
* SpringLoggerHelper.java
* Description: Defines logging commands
*/ 
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
    public void GetPersonByName(String name){
        logger.info("Fetching people with name: {}",name);
    }
    public void GetNonNullAddress(){
        logger.info("Fetching people nonnull address fields");
    }
    public void GetPersonByRegex(String pattern){
        logger.info("Fetching people with first name pattern: {}",pattern);
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

