package com.example.connor.rest_database.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String formatted_address;

    public Address() {
    }

    public String getAddress() {
        return formatted_address;
    }

    public void setAddress(String formatted_address) {
        this.formatted_address = formatted_address;
    }

}
