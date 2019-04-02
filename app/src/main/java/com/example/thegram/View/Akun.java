package com.example.thegram.View;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.thegram.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Akun extends Fragment {
    private Button btn_edit, btn_logout;
    private EditText ET_1, ET_2;
    View v;
    Context ctx;
    private String maiil, tllp, kata;
    public Akun() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_akun, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ET_1 = v.findViewById(R.id.tv_1);
        ET_1 = v.findViewById(R.id.tv_2);
        btn_edit = v.findViewById(R.id.bt_1);
        btn_logout = v.findViewById(R.id.bt_2);
        SharedPreferences preff = getContext().getSharedPreferences("save profile", MODE_PRIVATE);
        final SharedPreferences.Editor editorr = preff.edit();
        maiil = preff.getString("mail Yang Disimpan", "");
        tllp = preff.getString("tlp yang di simpan", "");

        if(!maiil.equals("") && !tllp.equals("")){
            ET_1.setText(maiil);
            ET_2.setText(tllp);
            //btn_edit
            //btn_edit.setVisibility(View.GONE);
        } else {
           // info.setText("Tidak ada yang disimpan");
            //ET_1.setText("tidak ada yang disimpan");
            //ET_2.setText("tidak ada yang disimpan");
            //ET_2.setText("tidak dapat disimpan");

            //btn_edit.setVisibility(View.GONE);
        }

        SharedPreferences pref = getContext().getSharedPreferences("login", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit(); // menggunakan final karena akan di akses di dalam inner class. lihat line 55 dan 58

        // TODO: Untuk mendapatkan value yang disimpan dari key "Kata Yang Disimpan"
        kata = pref.getString("username", "");

        if(!kata.equals("")){
            btn_logout.setVisibility(View.VISIBLE);
        } else {
            btn_logout.setVisibility(View.GONE);
        }
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Edit_Profile.class);
                startActivity(intent);

            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.remove("login");

                // TODO: Tambahkan ini jika tidak ada lagi yang dilakukan
                editor.commit();

                // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);


            }
        });
    }

}

