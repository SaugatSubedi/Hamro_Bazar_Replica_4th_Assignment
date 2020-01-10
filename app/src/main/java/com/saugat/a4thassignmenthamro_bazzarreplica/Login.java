package com.saugat.a4thassignmenthamro_bazzarreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btnLogin,btnRegister;

    private EditText etLoginEmail, etLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login() {
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrictModeClass.StrictMode();

        if (loginBLL.checkUser(email, password)) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Either email or password is incorrect", Toast.LENGTH_SHORT).show();
            etLoginEmail.requestFocus();
        }


    }
}
