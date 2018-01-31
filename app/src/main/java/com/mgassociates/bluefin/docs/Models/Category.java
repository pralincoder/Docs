package com.mgassociates.bluefin.docs.Models;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/26/18.
 */

public class Category {
    String id;
    String categoryName;
    ArrayList<String> subCategoriesid;
    ArrayList<String> subCategories;

    public Category(String id, String categoryName, ArrayList<String> subCategoriesid, ArrayList<String> subCategories) {
        this.id = id;
        this.categoryName = categoryName;
        this.subCategoriesid = subCategoriesid;
        this.subCategories = subCategories;
    }

    public Category() {

    }

    public ArrayList<String> getSubCategoriesid() {
        return subCategoriesid;
    }

    public void setSubCategoriesid(ArrayList<String> subCategoriesid) {
        this.subCategoriesid = subCategoriesid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public ArrayList<String> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<String> subCategories) {
        this.subCategories = subCategories;
    }
}
