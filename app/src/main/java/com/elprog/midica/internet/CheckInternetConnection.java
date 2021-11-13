package com.elprog.midica.internet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.elprog.midica.MainActivity;
import com.elprog.midica.current.AppController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class CheckInternetConnection extends BroadcastReceiver {

    public static ConnectivityRecieverListner connectivityRecieverListner;

    public CheckInternetConnection() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=cm.getActiveNetworkInfo();
        boolean isconnected=activenetwork!=null&&activenetwork.isConnectedOrConnecting();

        if(connectivityRecieverListner!=null){
            connectivityRecieverListner.onNetworkConnectionChanged(isconnected);

        }
    }
    public static boolean isConnected(){

        ConnectivityManager cm= (ConnectivityManager) AppController.getinstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=cm.getActiveNetworkInfo();
        return activenetwork!=null&&activenetwork.isConnectedOrConnecting();

    }
    public interface ConnectivityRecieverListner{

        void onNetworkConnectionChanged(boolean isConnected);
    }
}
