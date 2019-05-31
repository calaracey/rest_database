package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
     public class bounds {

         public location northeast ;
         public location southwest ;
     }

