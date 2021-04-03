package com.example.mccanals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataItem> mdata;
    NewAdapter newAdapter;
    private FirebaseAnalytics mFirebaseAnalytics;
    long pauseTime = 0, resumeTime = 0;
    String cat = "book";

    SharedPreferences preference;
    SharedPreferences sharedPreferences;
    String UserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // let's make this activity on full screen
        preference = getSharedPreferences("TimeWrap", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("userID", Context.MODE_PRIVATE);
        preference = getSharedPreferences("userID", Context.MODE_PRIVATE);

        UserId = preference.getString("user_Id", "0");

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_second);
        //hide Action Bar
        getSupportActionBar().hide();
        //init View
        recyclerView = findViewById(R.id.rv_item);
        //init firebase Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mdata = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
             cat = "book";
            System.out.println(extras);
            Log.d("aaaa",extras.toString() );
        }
// get data via the key
        String value1 = extras.getString("cat");
        if (value1 != null) {
            Log.d("aaaa" , value1);
            System.out.println(value1);
            cat = value1;
            // do something with the data
        }
     //   generatedatabook();
        if (cat.equals("book")) {
            generatedatabook();
        } else if (cat.equals("mobile")) {
            generatedatamobile();
        } else if (cat.equals("clothis")) {
            generatedataclothis();
        } else {
            generatedatafood();
        }
        // log event in firebase Analytics
        Bundle bundlelog = new Bundle();
        bundlelog.putString("move", "user enter the second screen with " + cat + " cat");
        mFirebaseAnalytics.logEvent("move", bundlelog);



        //Adapter init and setup
        newAdapter = new NewAdapter(this, mdata ,  cat);
        recyclerView.setAdapter(newAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    //method for generate data
    private void generatedatafood() {
        mdata.add(new DataItem("kabab", "Now You See Me !! Now you don't??", "1"));
        mdata.add(new DataItem("piza", "Now You See Me !! Now you don't??", "2"));
        mdata.add(new DataItem("pasta", "Now You See Me !! Now you don't??", "3"));
        mdata.add(new DataItem("shawerma", "Now You See Me !! Now you don't??", "4"));
        mdata.add(new DataItem("checken", "Now You See Me !! Now you don't??", "5"));
        mdata.add(new DataItem("meat", "Now You See Me !! Now you don't??", "6"));
        mdata.add(new DataItem("food7", "Now You See Me !! Now you don't??", "7"));
        mdata.add(new DataItem("food8", "Now You See Me !! Now you don't??", "8"));

    }

    private void generatedataclothis() {
        mdata.add(new DataItem("T shirt", "Now You See Me !! Now you don't??", "1"));
        mdata.add(new DataItem("shirt", "Now You See Me !! Now you don't??", "2"));
        mdata.add(new DataItem("skirt", "Now You See Me !! Now you don't??", "3"));
        mdata.add(new DataItem("jacket", "Now You See Me !! Now you don't??", "4"));
        mdata.add(new DataItem("T shirt", "Now You See Me !! Now you don't??", "5"));
        mdata.add(new DataItem("shirt", "Now You See Me !! Now you don't??", "6"));
        mdata.add(new DataItem("skirt", "Now You See Me !! Now you don't??", "7"));
        mdata.add(new DataItem("jacket", "Now You See Me !! Now you don't??", "8"));
    }

    private void generatedatamobile() {
        mdata.add(new DataItem("mobile1", "Apple iPhone 11 Pro", "1"));
        mdata.add(new DataItem("mobile2", "OnePlus 7T Pro", "2"));
        mdata.add(new DataItem("mobile1", "Samsung Galaxy S10", "3"));
        mdata.add(new DataItem("mobile2", "OnePlus 7T Pro", "4"));
        mdata.add(new DataItem("mobile1", "Apple iPhone 11 Pro", "5"));
        mdata.add(new DataItem("mobile2", "Huawei P30 Pro", "6"));
        mdata.add(new DataItem("mobile1", "Apple iPhone 11 Pro", "7"));
        mdata.add(new DataItem("mobile2", "Samsung Galaxy S10", "8"));
        mdata.add(new DataItem("mobile2", "Huawei P30 Pro", "9"));


    }

    private void generatedatabook() {
        mdata.add(new DataItem("book1", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "1"));
        mdata.add(new DataItem("book2", "Why you should switch to Signal or Telegram from WhatsApp, Today", "2"));
        mdata.add(new DataItem("book3", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "3"));
        mdata.add(new DataItem("book4", "Why you should switch to Signal or Telegram from WhatsApp, Today", "4"));
        mdata.add(new DataItem("book5", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "5"));
        mdata.add(new DataItem("book6", "Why you should switch to Signal or Telegram from WhatsApp, Today", "6"));
        mdata.add(new DataItem("book7", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "7"));
        mdata.add(new DataItem("book8", "Why you should switch to Signal or Telegram from WhatsApp, Today", "8"));
        mdata.add(new DataItem("book9", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "9"));
        mdata.add(new DataItem("book10", "Why you should switch to Signal or Telegram from WhatsApp, Today", "10"));
        mdata.add(new DataItem("book11", "Top 10 JavaScript Frameworks for Server Side Development in 2020", "11"));
        mdata.add(new DataItem("book12", "Why you should switch to Signal or Telegram from WhatsApp, Today", "12"));
        mdata.add(new DataItem("book13", "Now You See Me !! Now you don't??", "13"));
        mdata.add(new DataItem("book14", "Now You See Me !! Now you don't??", "14"));
    }
    @Override
    protected void onPause() {
        super.onPause();

        pauseTime = System.currentTimeMillis();

        Long time = preference.getLong("TotalForegroundTime", 0);
        //    long totalForgroundTime = preference.getLong(, 0) + );(pauseTime-resumeTime)



        // log event in firebase Analytics
        Bundle bundlelog = new Bundle();
        bundlelog.putString("timeTracker",  "User id : "+UserId+"cat List " +" page"+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        Log.d("aaaa",  String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        mFirebaseAnalytics.setUserProperty("timeTracker", "User id : "+UserId+"cat List " +" page"+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds" );
        mFirebaseAnalytics.logEvent("timeTracker", bundlelog);
        Log.d("aaaa" , "Tracking is done..");




    }

    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        //update foreground time
        resumeTime = System.currentTimeMillis();


    }


}
