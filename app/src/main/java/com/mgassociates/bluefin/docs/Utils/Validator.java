package com.mgassociates.bluefin.docs.Utils;

import android.content.Context;

import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/27/18.
 */

public class Validator {

    Context context;

    public Validator(Context context) {
        this.context = context;
    }

    public Category validateCategory(Category category){
        Category validatedCategory=new Category();
        ArrayList<String> validatedsubCategoryIDs=new ArrayList<>();
        ArrayList<String> validatedSubCategoryNames=new ArrayList<>();


        for(int i=0;i<category.getSubCategoriesid().size();i++){
            if(!((category.getSubCategoriesid().get(i))==null)&&(!(category.getSubCategoriesid().get(i).isEmpty()))){
                validatedsubCategoryIDs.add(category.getSubCategoriesid().get(i));
                validatedSubCategoryNames.add(category.getSubCategories().get(i));
            }
        }


        validatedCategory.setId(category.getId());
        validatedCategory.setCategoryName(category.getCategoryName());
        validatedCategory.setSubCategoriesid(validatedsubCategoryIDs);
        validatedCategory.setSubCategories(validatedSubCategoryNames);

        return validatedCategory;
    }

    public SubCategory validateSubCategory(SubCategory subCategory){
        SubCategory validatedSubCategory=new SubCategory();
        ArrayList<String> validatedLocations=new ArrayList<>();
        ArrayList<String> validatedSteps=new ArrayList<>();
        ArrayList<String> validatedDocs=new ArrayList<>();

        for(int i=0;i<subCategory.getLocations().size();i++){
            if(!((subCategory.getLocations().get(i))==null)&&(!(subCategory.getLocations().get(i).isEmpty()))){
                validatedLocations.add(subCategory.getLocations().get(i));
            }
        }

        for(int i=0;i<subCategory.getSteps().size();i++){
            if(!((subCategory.getSteps().get(i))==null)&&(!(subCategory.getSteps().get(i).isEmpty()))){
                validatedSteps.add(subCategory.getSteps().get(i));
            }
        }

        for(int i=0;i<subCategory.getRequiredDocs().size();i++){
            if(!((subCategory.getRequiredDocs().get(i))==null)&&(!(subCategory.getRequiredDocs().get(i).isEmpty()))){
                validatedDocs.add(subCategory.getRequiredDocs().get(i));
            }
        }

        validatedSubCategory.setId(subCategory.getId());
        validatedSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
        validatedSubCategory.setPhoneNumber(subCategory.getPhoneNumber());
        validatedSubCategory.setEmailAddress(subCategory.getEmailAddress());
        validatedSubCategory.setWebsite(subCategory.getWebsite());
        validatedSubCategory.setLocations(validatedLocations);
        validatedSubCategory.setBudget(subCategory.getBudget());
        validatedSubCategory.setSteps(validatedSteps);
        validatedSubCategory.setRequiredDocs(validatedDocs);

        return  validatedSubCategory;
    }
}
