package com.example.loginsignup;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class verification extends AppCompatActivity {

    private Button backArrowImageView;
    private TextView verificationHeadingTextView;
    private TextView alertTextView;
    private TextView otpTextView;
    private TextView phoneTextView;
    private EditText otp4EditText;
    private EditText otp1EditText;
    private EditText otp3EditText;
    private EditText otp2EditText;
    private Button verifyButton;
    private TextView remainingTimeTextView;
    private Button sendCodeAgainButton;
    private Button getCodeViaCallButton;
    private TextView codeTextView;

    String otp,phone;

    String message = "Is your Verification Code :";

    EditText etotp,etphone;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);
        backArrowImageView = findViewById(R.id.backArrowImageView);
        verificationHeadingTextView = findViewById(R.id.verificationHeadingTextView);
        alertTextView = findViewById(R.id.alertTextView);
        codeTextView = findViewById(R.id.codeTextView);
        otpTextView = findViewById(R.id.otpTextView);
        etphone = findViewById(R.id.phoneTextView);
        etotp = findViewById(R.id.otp4EditText);
        etotp = findViewById(R.id.otp1EditText);
        etotp = findViewById(R.id.otp3EditText);
        etotp= findViewById(R.id.otp2EditText);
        button = findViewById(R.id.verifyButton);
        remainingTimeTextView = findViewById(R.id.remainingTimeTextView);
        sendCodeAgainButton = findViewById(R.id.sendCodeAgainButton);
        getCodeViaCallButton = findViewById(R.id.getCodeViaCallButton);


        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(verification.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

                    sendOTP();
                }else {
                    ActivityCompat.requestPermissions(verification.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }


            }
        });



        backArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the signup activity here
                Intent intent = new Intent(verification.this, signup.class);
                startActivity(intent);
            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==100){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendOTP();
            }else{
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendOTP() {

        otp = otp1EditText.getText().toString();
        otp = otp2EditText.getText().toString();
        otp = otp3EditText.getText().toString();
        otp = otp4EditText.getText().toString();

        phone = phoneTextView.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(otp + " " + message);
        String phonenumber = phone;

        smsManager.sendMultipartTextMessage(phonenumber,null,parts,null,null);

    }

}
