package com.example.democit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView hello;

    Button send, newAct;

    EditText input;

    MyDataSingleton data = MyDataSingleton.getInstance();

    SharedPreferences storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);

        send = findViewById(R.id.button);
        newAct = findViewById(R.id.button2);
        input = findViewById(R.id.name);

        send.setOnClickListener(this);
        newAct.setOnClickListener(this);
        hello.setText(data.myName);

        storage = PreferenceManager.getDefaultSharedPreferences(this);

        //save some text
        String name = "sune";
        storage.edit().putString("username",name).commit();

    }

    @Override
    public void onClick(View view) {
        if (view == newAct){
            Intent i = new Intent(this, MyNewActivity.class);
            startActivity(i);
        }
        else{
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    data.myName = readURL("https://raw.githubusercontent.com/sunetb/U/master/greeting.txt");//"Good morning "+ input.getText().toString();

                }
            });
            t.start();
            hello.setText(data.myName);


            System.out.println(input.getText().toString());
        }

    }

    String readURL(String inputUrl){
        String value = "";
        URL url = null;
        try {
            url = new URL(inputUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            System.out.println(con);
            con.setRequestMethod("GET");
            InputStream i = con.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(i));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                value += inputLine + "\n";
            }
            in.close();
        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return value;
    }

}