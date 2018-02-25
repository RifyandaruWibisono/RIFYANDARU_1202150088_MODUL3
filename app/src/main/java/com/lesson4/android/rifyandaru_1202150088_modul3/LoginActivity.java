package com.lesson4.android.rifyandaru_1202150088_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText Username;
    private EditText Password;
    private Button Login;
    private String user = "EAD";
    private String pass = "MOBILE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Mengambil Id pada Layout Login
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.btnsubmit);
    }

    // Method untuk button Login
    public void login(View view) {
        if (valueLogin()) {
            Intent newAct = new Intent(this, MainActivity.class);
            startActivity(newAct);
        } else {
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }

    //Isi dari Logika untuk value login
    private boolean valueLogin() {
        boolean login;

        if (Username.getText().toString().equals(user) && Password.getText().toString().equals(pass)) {
            login = true;
        } else {
            login = false;
        }
        return login;
    }
}