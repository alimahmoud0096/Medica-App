package com.elprog.midica.internet;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elprog.midica.MainActivity;
import com.elprog.midica.R;

public class OfflineActivity extends AppCompatActivity {
Button retry_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_internet_connection);


        retry_btn=(Button)findViewById(R.id.retry_btn);
        retry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {

        finish();

    }
}
