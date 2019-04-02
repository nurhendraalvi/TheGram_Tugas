package com.example.thegram.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.thegram.R;


public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "LoginPrefs";
    private Button btnlogin;
    private EditText tvUser, tvPass;
    String SUsername, SPass;
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean savelogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btn_login);
        tvUser = findViewById(R.id.username);
        tvPass = findViewById(R.id.pass);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
       btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SUsername = tvUser.getText().toString();
                SPass = tvPass.getText().toString();
                if (SUsername.equals("Alvi")&& SPass.equals("1234")){
                    editor.putString("username", SUsername);
                    editor.commit();
                    Intent a = new Intent(getApplicationContext(), home.class);
                    a.putExtra("username", SUsername);
                    a.putExtra("password", SPass);
                    startActivity(a);
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }

            }
       });
    }
}
