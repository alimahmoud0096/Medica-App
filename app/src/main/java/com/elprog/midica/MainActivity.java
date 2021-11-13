package com.elprog.midica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elprog.midica.controller.customRecyclerDoctors;
import com.elprog.midica.current.AppController;
import com.elprog.midica.internet.CheckInternetConnection;
import com.elprog.midica.internet.OfflineActivity;
import com.elprog.midica.model.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends  AppCompatActivity implements CheckInternetConnection.ConnectivityRecieverListner{
    private Handler h = new Handler();
    ImageView back_i;
    public  static MainActivity mInstance;
    RelativeLayout menu_frameLayout;
    List<Doctor> doctors;
    ImageView  map_ic;
    private boolean connectionAvailable = true;
    RecyclerView institutions_recycler;
   String URL_Doctors="https://kemronbennet.000webhostapp.com/medica/Doctors.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        map_ic=(ImageView)findViewById(R.id.map_ic);
        map_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        back_i=(ImageView)findViewById(R.id.back_ic);
        doctors=new ArrayList<>();
        menu_frameLayout=(RelativeLayout) findViewById(R.id.menu_frameLayout);


        menu_frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                FullScreenDialog dialog = new FullScreenDialog();
                FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
                dialog.show(ft, FullScreenDialog.TAG);
            }
        });


         institutions_recycler = (RecyclerView) findViewById(R.id.institutions_recycler);

        loadDoctors();

       /* LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.services, null);
        fragments.addView(v);*/

    }



    private void loadDoctors() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_Doctors,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject doct = array.getJSONObject(i);
                                 //adding the product to product list
                                doctors.add(new Doctor(
                                        doct.getString("doctor_id"),
                                        doct.getString("doctor_name"),
                                        doct.getString("doctor_email"),
                                        doct.getString("doctor_password"),
                                        doct.getString("doctor_phone"),
                                        doct.getString("doctor_address"),
                                        doct.getString("doctor_price"),
                                        doct.getString("image")
                                ));

                            }
                            // Create adapter passing in the sample user data
                            customRecyclerDoctors adapter = new customRecyclerDoctors(doctors);
                            // Attach the adapter to the recyclerview to populate items
                            institutions_recycler.setAdapter(adapter);
                            // Set layout manager to position the items
                            institutions_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //creating adapter object and setting it to recyclerview

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void CheckInternetC() {



        boolean isConnected=CheckInternetConnection.isConnected();
        if(!isConnected){
        changeActivity();
        }
    }

    private void changeActivity() {

            startActivity(new Intent(this, OfflineActivity.class));

    }
    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        CheckInternetConnection checkInternetConnection=new CheckInternetConnection();
        registerReceiver(checkInternetConnection,intentFilter);
        AppController.getinstance().setConnectivityListner((CheckInternetConnection.ConnectivityRecieverListner) this);

    }

    @Override
    protected void onStart(){
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        if(!isConnected){
            changeActivity();
        }
    }
}
