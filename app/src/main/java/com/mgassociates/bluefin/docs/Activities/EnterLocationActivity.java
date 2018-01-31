package com.mgassociates.bluefin.docs.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.R;

public class EnterLocationActivity extends AppCompatActivity {

    EditText city;
    Button viewBUtton;
    DatabaseHandler databaseHandler;
    Category mainCategoryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_location);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String mainCategoryID = getIntent().getExtras().getString("CategoryID");
        databaseHandler=new DatabaseHandler(this);
        mainCategoryInfo=databaseHandler.getCategory(mainCategoryID);

        String category=null;

        if(mainCategoryID.equalsIgnoreCase("pp")){
            category="Department Of Passport";
        }
        else if(mainCategoryID.equalsIgnoreCase("bb")){
            category="Department of Transportation";
        }
        else if(mainCategoryID.equalsIgnoreCase("lc")){
            category="Department of Transportation";

        }
        else if(mainCategoryID.equalsIgnoreCase("vc")){
            category="Election Commission";

        }
        else {
            category="Malpot Office";
        }

        city=(EditText)findViewById(R.id.cityName);
        viewBUtton=(Button)findViewById(R.id.gotoMapButton);


        final String finalCategory = category;
        viewBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cityName=city.getText().toString().trim();
                try {
                    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode(finalCategory +","+cityName));
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                } catch (ActivityNotFoundException ex) {
                    try {

                    } catch (ActivityNotFoundException innerEx) {
                        Snackbar.make(view, "Please Install A Map Application", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
