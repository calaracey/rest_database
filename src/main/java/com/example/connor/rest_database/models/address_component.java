package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

     public class address_component{
        public String long_name;
        public String short_name;
        public String[] types ;
    }

