package com.example.hng_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mSignin, emSignup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;
    String userDetails;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.Log_mail);
        mPassword = findViewById(R.id.Log_password);
        mSignin = findViewById(R.id.btn_signin);
        emSignup= findViewById(R.id.button_signup);
        sharedPreferences = getSharedPreferences("MYPREFRENCE", MODE_PRIVATE);
        savelogincheckbox = findViewById(R.id.checkBox);
        editor = sharedPreferences.edit();
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword;
                String newEmail;
                String userDetails;

                sharedPreferences = getSharedPreferences("MYPREFRENCE", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                newEmail = mEmail.getText().toString();
                newPassword = mPassword.getText().toString();




                userDetails = sharedPreferences.getString(newEmail + newPassword + "data", "Email or Password is incorrect");
                if(userDetails.equals("Email or Password is incorrect")){
                    showToast(userDetails);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("data", userDetails);


                    editor.apply();


                    Intent dataScreen = new Intent(MainActivity.this, com.example.hng_mobile.DataActivity.class);
                    startActivity(dataScreen);
                }

            }
        });

        emSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupScreen = new Intent(MainActivity.this, com.example.hng_mobile.SignupActivity.class);
                startActivity(signupScreen);

            }
        });


    }
    private void showToast(String toastMessage){
        Toast.makeText(this, toastMessage,Toast.LENGTH_SHORT).show();
    }


}
