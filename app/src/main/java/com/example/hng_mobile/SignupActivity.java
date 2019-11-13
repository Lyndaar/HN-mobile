package com.example.hng_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText mEmail, mPassword, mFullname, mUsername;
    Button mSignup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox terms_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

         mUsername = findViewById(R.id.et_name);
         mFullname = findViewById(R.id.et_fullname);
         mEmail = findViewById(R.id.et_email);
         mPassword = findViewById(R.id.et_password);
         mSignup= findViewById(R.id.btn_signin);
         terms_checkbox = findViewById(R.id.checkBox);


        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUser;
                String newPassword;
                String newEmail;
                String newName;


                sharedPreferences = getSharedPreferences("MYPREFRENCE", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                newUser = mUsername.getText().toString();
                newEmail = mEmail.getText().toString();
                newName = mFullname.getText().toString();
                newPassword = mPassword.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(newEmail + newPassword + "data", newName + "\n" + newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(loginScreen);

                savelogin=sharedPreferences.getBoolean("savelogin",true);
                if(savelogin==true){
                    mEmail.setText(sharedPreferences.getString("username",null));
                    mPassword.setText(sharedPreferences.getString("password",null));
                }

                }


        });
    }

}
