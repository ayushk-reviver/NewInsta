package com.example.insta2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject object = new ParseObject("score");
        object.put("username", "nish");
        object.put("score", 45);
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.i("Success", "We saved the score!!!");
            }
        });

    /*ParseQuery<ParseObject> query = ParseQuery.getQuery("score");


    query.findInBackground(new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> objects, ParseException e) {
            if(objects.size() >0)
            {
                for (ParseObject object : objects)
                {
                    Log.i("username",object.getString("username"));
                    Log.i("score",Integer.toString(object.getInt("score")));
                }

            }
        }
    });*/

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }
}
