package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
     public class geometry{
         public bounds bounds;
        public String location_type ;
        public location location;
        public bounds viewport;
    }

