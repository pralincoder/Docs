package com.mgassociates.bluefin.docs.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.DatabaseUtils.Datas;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout requiredDocument, stepGuidance, demoForm, officeLocations;

    DatabaseHandler databaseHandler;
    SharedPreferences sharedPreferences;
    Datas datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("suchanaPaati", 0); // 0 - for private mode

        if (pref.getString("databaseCreated", "").equalsIgnoreCase("created")) {


        } else {

            databaseHandler = new DatabaseHandler(this);
            datas = new Datas();

            fillUpDataBase();

            SharedPreferences.Editor editor = pref.edit();
            editor.putString("databaseCreated", "created"); // Storing boolean - true/false
            editor.commit();
        }


        requiredDocument = (LinearLayout) findViewById(R.id.requiredDocumentLL);
        stepGuidance = (LinearLayout) findViewById(R.id.stepsLL);
        demoForm = (LinearLayout) findViewById(R.id.demoFormLL);
        officeLocations = (LinearLayout) findViewById(R.id.officeLocationLL);


        requiredDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategory(1);
            }
        });

        stepGuidance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategory(2);
            }
        });

        demoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategory(3);

            }
        });
        officeLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategory(4);
            }
        });
    }

    private void fillUpDataBase() {

        ArrayList <Category> categories = new ArrayList <>();
        ArrayList <SubCategory> subCategories = new ArrayList <>();

        categories = datas.getCategoryDatas();
        subCategories = datas.getSubCategoryDatas();

        for (Category category : categories) {
            databaseHandler.addCategory(category);
        }

        for (SubCategory subCategory : subCategories) {
            databaseHandler.addSubCategory(subCategory);
        }
    }

    private void gotoCategory(int i) {

        String userChoice = null;

        if (i == 1) {
            userChoice = "reqDocs";

        } else if (i == 2) {
            userChoice = "steps";
        } else if (i == 3) {
            userChoice = "demoForms";

        } else if (i == 4) {
            userChoice = "location";

        }
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        intent.putExtra("userChoice", userChoice);
        startActivity(intent);

    }
}
