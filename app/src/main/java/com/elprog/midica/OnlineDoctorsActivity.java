package com.elprog.midica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elprog.midica.current.AppController;

public class OnlineDoctorsActivity extends AppCompatActivity {

    LinearLayout fragments;
    ImageView back_ic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back_ic=(ImageView)findViewById(R.id.back_ic);
        back_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   finish();
                  startActivity(i);
            }
        });
        fragments=(LinearLayout)findViewById(R.id.fragments);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.online_doctors, null);
        fragments.addView(v);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(getApplicationContext(), MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
        startActivity(i);
    }

}
