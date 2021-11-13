package com.elprog.midica.current;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.elprog.midica.internet.CheckInternetConnection;

public class AppController extends Application {

    //Getting tag it will be used for displaying log and it is optional
    public static final String TAG = AppController.class.getSimpleName();

    //Creating a volley request queue object
    private RequestQueue mRequestQueue;

    //Creatting class object
    private static AppController mInstance;

    //Creating sharedpreferences object
    //We will store the user data in sharedpreferences
    private SharedPreferences sharedPreferences;

    //class instance will be initialized on app launch
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //Public static method to get the instance of this class
    public static synchronized AppController getInstance() {
        return mInstance;
    }

    //This method would return the request queue
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mInstance);
        }
        return mRequestQueue;
    }


    //This method would add the requeust to the queue for execution
    public <T> void addToRequestQueue(Request<T> req) {
        //Setting a tag to the request
        req.setTag(TAG);

        //calling the method to get the request queue and adding the requeust the the queuue
        getRequestQueue().add(req);
    }

    //method to cancle the pending requests
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    //Method to get sharedpreferences
    public SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    //This method will clear the sharedpreference
    //It will be called on logout
    public void logout() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.apply();
    }

    //This method will store the user data on sharedpreferences
    //It will be called on login
    public void loginUser(String name, String email,String password,String phone) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
       // editor.putString(Constants.USER_ID, id+"");
        editor.putString(Constants.USER_EMAIL, email);
        editor.putString(Constants.USER_NAME, name);
        editor.putString(Constants.USER_PHONE, phone);
        editor.putString(Constants.USER_PASSWORD, password);

        editor.putBoolean(Constants.IS_LOGGED_IN, true);
        editor.apply();
    }

    //This method will check whether the user is logged in or not
    public boolean isLoggedIn() {
        return getSharedPreferences().getBoolean(Constants.IS_LOGGED_IN, false);
    }



    //This method will return the username of logged in user
    public String getUserName() {

        return getSharedPreferences().getString(Constants.USER_NAME, null);
    }
    public String getUseremail() {

        return getSharedPreferences().getString(Constants.USER_EMAIL, null);
    }
    public String getUserpassword() {

        return getSharedPreferences().getString(Constants.USER_PASSWORD, null);
    }
    public String getUserphone() {

        return getSharedPreferences().getString(Constants.USER_PHONE, null);
    }
    public  static synchronized AppController getinstance(){
        return mInstance;
    }
    public void setConnectivityListner(CheckInternetConnection.ConnectivityRecieverListner listner){

        CheckInternetConnection.connectivityRecieverListner =listner;
    }
}

