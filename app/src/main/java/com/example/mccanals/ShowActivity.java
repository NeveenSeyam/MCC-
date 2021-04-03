package com.example.mccanals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShowActivity extends AppCompatActivity {
    List<DataItem> mdata;
    TextView title;
    TextView dec ;
    ImageView img ;
    long pauseTime = 0, resumeTime = 0;
    SharedPreferences preference;
    SharedPreferences sharedPreferences;
    private FirebaseAnalytics mFirebaseAnalytics;
    String UserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        preference = getSharedPreferences("TimeWrap", Context.MODE_PRIVATE);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        sharedPreferences = getSharedPreferences("userID", Context.MODE_PRIVATE);
        preference = getSharedPreferences("userID", Context.MODE_PRIVATE);

        UserId = preference.getString("user_Id", "0");

        mdata = new ArrayList<DataItem>();
        String name ;
        String text ;
        title = findViewById(R.id.item_title);
        dec = findViewById(R.id.item_details);
        img = findViewById(R.id.item_img);
        Bundle extras = getIntent().getExtras();
            String cat = "book";
        String value = extras.getString("cat");
        if (value != null) {
            Log.d("aaaa" , value);
            System.out.println(value);
            cat = value;
            // do something with the data
        }
        //   generatedatabook();
        if (cat.equals("book")) {
            generatedatabook();
            img.setImageResource(R.drawable.book);

        } else if (cat.equals("mobile")) {
            generatedatamobile();
            img.setImageResource(R.drawable.mobile);

        } else if (cat.equals("clothis")) {
            generatedataclothis();
            img.setImageResource(R.drawable.clothis);

        } else {
            generatedatafood();
            img.setImageResource(R.drawable.food);

        }


        String value1 = extras.getString("postion");
        if (value1 != null) {
            Log.d("aaaa", value1 );
      // int data =  mdata.indexOf(Integer.valueOf(value1));
       name = mdata.get(0).title;
       text = mdata.get(0).content;
       title.setText(name.toString());
       dec.setText(text.toString());
        }


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
        bundlelog.putString("timeTracker","User id : "+UserId+ title+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        Log.d("aaaa",  String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        mFirebaseAnalytics.setUserProperty("timeTracker",  "User id : "+UserId+title +" page"+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds" );
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