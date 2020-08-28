package com.example.instagramclonefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignupActivity extends AppCompatActivity {

    private EditText edtUsername, edtEmail, edtPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtEmail = findViewById(R.id.edtSignUpEmail);
        edtUsername = findViewById(R.id.edtSignUpUserName);
        edtPassword = findViewById(R.id.edtSignUpPassword);
        btnRegister = findViewById(R.id.btnSignUp);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUsername.getText().toString());
                appUser.setPassword(edtPassword.getText().toString());
                appUser.setEmail(edtEmail.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(SignupActivity.this,appUser.get("username") + "Successfully Registered",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        }else {
                            FancyToast.makeText(SignupActivity.this, e.getMessage() ,FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }

                    }
                });
            }
        });


    }
}