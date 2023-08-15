package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class signup extends AppCompatActivity {


    TextInputEditText textInputEditTextfullname,textInputEditTextphoneno, textInputEditTextpassword,textInputEditTextusername;
    CheckBox termsCheckBox;
     Button signUpButton;
    TextView signInTextView;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        textInputEditTextfullname = findViewById(R.id.fullName);
        textInputEditTextphoneno = findViewById(R.id.phoneno);
        textInputEditTextpassword = findViewById(R.id.password);
        textInputEditTextusername = findViewById(R.id.username);

        progressBar = findViewById(R.id.progress);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        signUpButton = findViewById(R.id.signUpButton);
        signInTextView = findViewById(R.id.signInTextView);

        signUpButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String fullname, phoneno, password,username;

                fullname = String.valueOf(textInputEditTextfullname.getText());
                phoneno = String.valueOf(textInputEditTextphoneno.getText());
                password = String.valueOf(textInputEditTextpassword.getText());
                username = String.valueOf((textInputEditTextusername.getText()));

                if(!fullname.equals("") && !phoneno.equals("") && !password.equals("") && !username.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "fullname";
                            field[1] = "phoneno";
                            field[2] = "password";
                            field[3] = "username";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = "full name";
                            data[1] = "phone no";
                            data[2] = "password";
                            data[3] = "user name";

                            PutData putData = new PutData("http://192.168.18.115:63342/loginregister/signup.php?_ijt=j805b4f498mj0r69ci3tv9ass3&_ij_reload=RELOAD_ON_SAVE", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();

                                    if ( result.equals("Sign Up Success")){
                                        Intent intent = new Intent(signup.this, verification.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All Fields are required", Toast.LENGTH_SHORT).show();
                }

            }
        });


        signInTextView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(signup.this, signin.class);
                startActivity(intent);
            }
        });




    }

}
