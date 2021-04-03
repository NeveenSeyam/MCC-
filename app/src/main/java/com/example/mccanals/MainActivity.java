package com.example.mccanals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
Button book ,clothis,food ,mobile;
SharedPreferences sharedPreferences;
    NewAdapter newAdapter;
    SharedPreferences preference;

    private FirebaseAnalytics mFirebaseAnalytics;
    long pauseTime = 0, resumeTime = 0;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // let's make this activity on full screen
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //hide Action Bar
        getSupportActionBar().hide();
        //init Buttons
        book=findViewById(R.id.books);
        clothis=findViewById(R.id.clothis);
        food=findViewById(R.id.food);
        mobile=findViewById(R.id.moblie);
        //init Intent For movement
        final Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        //init sharedPreference to save data about my category
        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("userID", Context.MODE_PRIVATE);
        preference = getSharedPreferences("userID", Context.MODE_PRIVATE);

          UserId = preference.getString("user_Id", "0");
         Log.d("aaaa" , UserId);
         if(UserId.equals("0")){

        UUID uuid = UUID.randomUUID();
        Log.d("aaaa" ,uuid.toString() );
        SharedPreferences.Editor myedit=sharedPreferences.edit();
        myedit.putString("user_Id ",uuid.toString());
        Log.d("aaaa" , uuid.toString());
              myedit.commit();

         }

        //init firebase Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(sharedPreferences.getString("book","0"));
                if (sharedPreferences.getString("book","0").equalsIgnoreCase("5")){
                    mFirebaseAnalytics.setUserProperty("intrests","book");
                }else{
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putString("book", String.valueOf(count++));
                    myedit.commit();

                }
                intent.putExtra("cat","book");
                startActivity(intent);
            }
        });
        clothis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(sharedPreferences.getString("clothis","0"));
                if (sharedPreferences.getString("clothis","0").equalsIgnoreCase("5")){
                    mFirebaseAnalytics.setUserProperty("intrests","clothis");
                }else{
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putString("clothis", String.valueOf(count++));
                    myedit.commit();
                }
                intent.putExtra("cat","clothis");
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(sharedPreferences.getString("food","0"));
                if (sharedPreferences.getString("food","0").equalsIgnoreCase("5")){
                    mFirebaseAnalytics.setUserProperty("intrests","food");
                }else{
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putString("food", String.valueOf(count++));
                    myedit.commit();
                }
                intent.putExtra("cat","food");
                startActivity(intent);
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(sharedPreferences.getString("mobile","0"));
                if (sharedPreferences.getString("mobile","0").equalsIgnoreCase("5")){
                    mFirebaseAnalytics.setUserProperty("intrests","mobile");
                }else{
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putString("mobile", String.valueOf(count++));
                    myedit.commit();
                }
                intent.putExtra("cat","mobile");
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

        pauseTime = System.currentTimeMillis();



        // log event in firebase Analytics
        Bundle bundlelog = new Bundle();
        bundlelog.putString("timeTracker",  "User id : "+UserId+" Main " +" page"+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        Log.d("aaaa",  String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds");
        mFirebaseAnalytics.setUserProperty("timeTracker",  "User id : "+UserId+"Main" +" page"+String.valueOf(TimeUnit.SECONDS.convert((pauseTime-resumeTime), TimeUnit.MILLISECONDS)) + " Seconds" );
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
