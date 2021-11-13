package com.elprog.midica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elprog.midica.current.AppController;
import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;


public class Activity_Rigister extends AppCompatActivity {
    LinearLayout fragments;
    EditText user_name_edt, last_name_edt, email_edt, pass1_edt, pass2_edt, phone_number_edt;
    Button register_btn;
    String REGISTER_URL = "https://kemronbennet.000webhostapp.com/medica/Rigister.php";
    SimpleArcDialog mDialog;
    ACProgressFlower dialog;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_actvity);
        context=this;
        fragments = (LinearLayout) findViewById(R.id.fragments);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.auth_register, null);
        fragments.addView(v);
        user_name_edt = v.findViewById(R.id.user_name_edt);
        last_name_edt = v.findViewById(R.id.last_name_edt);
        email_edt = v.findViewById(R.id.email_edt);
        pass1_edt = v.findViewById(R.id.pass1_edt);
        pass2_edt = v.findViewById(R.id.pass2_edt);
        phone_number_edt = v.findViewById(R.id.phone_number_edt);

        register_btn = v.findViewById(R.id.register_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user_name_edt.getText().toString().isEmpty() && !last_name_edt.getText().toString().isEmpty()
                        && !email_edt.getText().toString().isEmpty() && !pass1_edt.getText().toString().isEmpty()
                        && !pass2_edt.getText().toString().isEmpty() && !phone_number_edt.getText().toString().isEmpty()
                        && pass1_edt.getText().toString().equals(
                        pass2_edt.getText().toString())) {

                    registerUser(user_name_edt.getText().toString().trim(), last_name_edt.getText().toString().trim()
                            , email_edt.getText().toString().trim(), pass1_edt.getText().toString().trim(),
                            phone_number_edt.getText().toString().trim());
                } else {


                    Toast.makeText(getApplicationContext(), "Please fill all field or password doesn't match", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    private void registerUser(final String user_name_edt,
                              final String last_name_edt,
                              final String email_edt,
                              final String pass1_edt,
                              final String phone_number_edt) {
        dialog = new ACProgressFlower.Builder(context)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .text("Registering please wait")
                .fadeColor(Color.DKGRAY).build();
        dialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //do stuffs with response of post
                        if (response.equals("no")) {
                            Toast.makeText(getApplicationContext(), "user exist", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                JSONObject reader = new JSONObject(response);

                                String success = reader.getString("success");
                                if (success.equals("1")) {

                                    Toast.makeText(getApplicationContext(), reader.optString("message"), Toast.LENGTH_SHORT).show();
                                   Intent i=new Intent(getApplicationContext(), MainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                    AppController.getInstance().loginUser(user_name_edt + " " + last_name_edt, email_edt, pass1_edt, phone_number_edt);
                                    startActivity(i);
                                } else {

                                    Toast.makeText(getApplicationContext(), reader.optString("message"), Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                       //mDialog.dismiss();
                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //do stuffs with response erroe
                      // mDialog.dismiss();
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put("user_name", user_name_edt + " " + last_name_edt);
                params.put("email", email_edt);
                params.put("password", pass1_edt);

                params.put("phone", phone_number_edt);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
