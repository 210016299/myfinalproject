package com.joseph.myfinalproject.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int house_number;
    private String street_address;
    private String suburb;

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    
}
