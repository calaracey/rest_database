package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeoCodeResponse {

     public String status ;
        public results[] results ;
        public GoogleGeoCodeResponse() {

        }
    }

