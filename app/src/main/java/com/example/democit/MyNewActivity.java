package com.example.democit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MyNewActivity extends AppCompatActivity {

    TextView t;
    SharedPreferences storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new);

        t = findViewById(R.id.textView);

        storage = PreferenceManager.getDefaultSharedPreferences(this);

        //Get text stored under the key "username"
        String name = storage.getString("username", "no value found");

        t.setText(name);
    }
}