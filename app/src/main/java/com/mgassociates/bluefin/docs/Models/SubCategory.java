package com.mgassociates.bluefin.docs.Models;

import android.support.annotation.ArrayRes;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/26/18.
 */

public class SubCategory {
    String id;
    String subCategoryName;
    String phoneNumber;
    String emailAddress;
    String website;
    ArrayList<String> locations;
    int budget;
    ArrayList<String> steps;
    ArrayList<String> requiredDocs;



    public SubCategory(String id, String subCategoryName, String phoneNumber, String emailAddress, String website, ArrayList<String> locations, int budget, ArrayList<String> steps, ArrayList<String> requiredDocs) {
        this.id = id;
        this.subCategoryName = subCategoryName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.website = website;
        this.locations = locations;
        this.budget = budget;
        this.steps = steps;
        this.requiredDocs = requiredDocs;
    }



    public SubCategory() {

    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public ArrayList<String> getRequiredDocs() {
        return requiredDocs;
    }

    public void setRequiredDocs(ArrayList<String> requiredDocs) {
        this.requiredDocs = requiredDocs;
    }
}
