package com.example.appclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText ipAdd;
    private EditText sport;
    private Button button;
    private Button button2;

    connect_to_server connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipAdd = findViewById(R.id.ipAdd);
        sport = findViewById(R.id.sport);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);
    }

    public void connectToServer(View view) {
        Log.d(LOG_TAG, "'Connect' Button clicked!");
        if (ipAdd.getText().toString().equals("") || sport.getText().toString().equals("")) {
            Toast.makeText(this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        connect = new connect_to_server();
        connect_to_server.LOG_TAG = LOG_TAG;
        connect_to_server.context = this;
        connect_to_server.ip = ipAdd.getText().toString();
        connect_to_server.port = Integer.parseInt(sport.getText().toString());
        Log.d(LOG_TAG, "IP Address is " + ipAdd.getText().toString());

        connect.execute();
        String returned = "";
        try {
            returned = connect.get();
        } catch (ExecutionException e) {
            Log.d(LOG_TAG, e.toString());
        } catch (InterruptedException e) {
            Log.d(LOG_TAG, e.toString());
        }
        Log.d(LOG_TAG, "Message returned : " + returned);

        if (!returned.equals("connected")){
            Toast.makeText(this, "Unable to Connect\nTry Again", Toast.LENGTH_LONG).show();
        }
        else {
            sport.setVisibility(View.INVISIBLE);
            ipAdd.setText("");
            ipAdd.setHint("Message");
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
        }
    }

    public void sendMessage(View view) {
        connect = new connect_to_server();
        connect.message = ipAdd.getText().toString();
        try
        {
            connect.execute();
        }
        catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "Exception in MainActivity: " + e.toString());
        }
        if (connect.message.equalsIgnoreCase("Over")) {
            sport.setVisibility(View.VISIBLE);
            sport.setText("");
            ipAdd.setHint("IPv4");
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.INVISIBLE);
        }
        ipAdd.setText("");
    }
}

