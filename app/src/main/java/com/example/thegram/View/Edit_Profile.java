package com.example.thegram.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thegram.R;

public class Edit_Profile extends AppCompatActivity {
    private EditText tv_1, tv_2, tv_3;
    private Button btn1, btn2;
    String nama, mail, tlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);
        tv_1 = findViewById(R.id.name);
        tv_2 = findViewById(R.id.email);
        tv_3 = findViewById(R.id.tlp_number);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("save prpfile", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        //nama = tv_1.getText().toString();
        //mail = tv_2.getText().toString();
        //tlp = tv_3.getText().toString();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_1.getText().toString().equals("") &&  !tv_2.getText().toString().equals("") && !tv_3.getText().toString().equals("")) {

                    // TODO: Ini digunakan untuk menyimpan suatu value ke "Kata Yang Disimpan"
                    editor.putString("nama Yang Disimpan", tv_1.getText().toString());
                    editor.putString("mail Yang Disimpan", tv_2.getText().toString());
                    editor.putString("tlp Yang Disimpan", tv_3.getText().toString());

                    // TODO: Tambahkan ini jika sudah tidak ada lagi yang dilakukan
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), Akun.class);
                    startActivity(intent);

                    // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Anda Belum Beruntung", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Akun.class));

                // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi
                finish();
            }
        });
    }
}
