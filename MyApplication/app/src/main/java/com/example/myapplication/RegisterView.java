package com.example.myapplication;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterView extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirm_password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        username = (EditText) findViewById(R.id.emailid);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);
    }
    public String validation(String username,String password,String confirm_password){
        if(password.matches("") || username.matches("") || (!password.matches(confirm_password))){
            return "Please Fill the Field";
        }
        if(password.length()<8){
            return "Minimum Length of Password must be 8";
        }
        if(username.split("@").length<2){
            return "Invalid Username";
        }
        return "SUCCESS";
    }
    public void getRegister(View view){
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String confirm_password = this.confirm_password.getText().toString();
        String Message = validation(username,password,confirm_password);
        if(Message.matches("SUCCESS")){
            Toast.makeText(getApplicationContext(), "Updating Soon",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), Message,Toast.LENGTH_SHORT).show();
        }
    }
}
