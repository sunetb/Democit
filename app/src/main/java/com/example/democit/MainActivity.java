package com.example.democit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView hello;

    Button send;

    EditText input;

    MyDataSingleton data = MyDataSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);

        send = findViewById(R.id.button);

        input = findViewById(R.id.name);

        send.setOnClickListener(this);
        hello.setText(data.myName);
    }

    @Override
    public void onClick(View view) {
        data.myName = "Good morning "+ input.getText().toString();
        hello.setText(data.myName);


        System.out.println(input.getText().toString());


    }
}