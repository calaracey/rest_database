package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
     public class results{
        public String formatted_address ;
        public geometry geometry ;
        public String[] types;
        public address_component[] address_components;
    }

