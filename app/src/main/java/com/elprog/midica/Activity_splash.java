package com.elprog.midica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_splash extends Activity {
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private ProgressBar progressBar;
    private Handler handler = new Handler();
    private int progressStatus = 0;

    private int sum1=0,sum2 = 0 ;

    //Create a handler responsible for updating progress
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Indicates that the message was sent by this program
            if (msg.what == 0x111){
                progressBar.setProgress(sum1);
                //bar2.setProgress(sum2);
            }
        }
    };
    //Simulation time
    Thread thread = new Thread(){
        @Override
        public void run() {
            while (sum1 < 100){
                //Bar1 get percentage of work done
                if (sum1 > 100){
                    sum1 = 100;


                    thread.stop();
                    if (sum2<100){
                        sum2 += (int) (Math.random()*25);
                    }else {
                        sum2 = 100;


                    }
                    sum1=0;
                }else {
                    sum1 = sum1 + (int) (Math.random()*25);
                }
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //Update ProgressBar
                mHandler.sendEmptyMessage(0x111);
            }

            Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
            Activity_splash.this.startActivity(mainIntent);
            Activity_splash.this.finish();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       progressBar = (ProgressBar) findViewById(R.id.splash_pb_loading);
        thread.start();

    }
}
