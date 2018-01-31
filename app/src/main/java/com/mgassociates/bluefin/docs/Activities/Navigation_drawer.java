package com.mgassociates.bluefin.docs.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.DatabaseUtils.Datas;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

public class Navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout requiredDocument, stepGuidance, demoForm, officeLocations;

    DatabaseHandler databaseHandler;
    SharedPreferences sharedPreferences;
    Datas datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView=(ImageView)findViewById(R.id.drawer_icon);




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
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        Intent intent = new Intent(Navigation_drawer.this, CategoryActivity.class);
        intent.putExtra("userChoice", userChoice);
        startActivity(intent);

    }


    private void fillUpDataBase() {
        ArrayList<Category> categories = new ArrayList <>();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
