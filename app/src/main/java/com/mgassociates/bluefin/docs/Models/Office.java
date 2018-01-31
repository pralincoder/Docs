package com.mgassociates.bluefin.docs.Models;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/26/18.
 */

public class Office {

    String id;
    String name;
    String number;
    String address;
    String emailAddress;
    ArrayList<String> locations;
    ArrayList<String> categories;
    int budget;

    public Office(String id, String name, String number, String address, String emailAddress, ArrayList<String> locations, ArrayList<String> categories, int budget) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.emailAddress = emailAddress;
        this.locations = locations;
        this.categories = categories;
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
