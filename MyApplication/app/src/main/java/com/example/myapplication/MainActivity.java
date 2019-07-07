package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
    public String validation(String username,String password){
        if(password.matches("") || username.matches("")){
            return "Please Fill the Field";
        }
        if(password.length()<8){
            return "Minimum Length of Password is 8";
        }
        if(username.split("@").length<2){
            return "Invalid Username";
        }
        return "SUCCESS";
    }
    public void getSign(View view){
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String Message = validation(username,password);
        if(Message.matches("SUCCESS")){
            Toast.makeText(getApplicationContext(),"Updating Soon",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), Message,Toast.LENGTH_SHORT).show();
        }
    }
    public void getRegister(View view){
        Intent intent = new Intent(MainActivity.this,RegisterView.class);
        startActivity(intent);
    }

}
