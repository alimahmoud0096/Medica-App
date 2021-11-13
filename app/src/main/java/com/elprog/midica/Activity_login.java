package com.elprog.midica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.elprog.midica.CustomViews.MyButton;
import com.elprog.midica.current.AppController;
import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class Activity_login extends AppCompatActivity {

LinearLayout fragments;
    String URL_LOGIN="https://kemronbennet.000webhostapp.com/medica/Login.php";
    MyButton signup_btn,login_btn;
    EditText pass1,phone;
    SimpleArcLoader mDialog;
    ACProgressFlower dialog;//https://github.com/cloudist/ACProgressLite
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_actvity);
        context=this;
        fragments=(LinearLayout)findViewById(R.id.fragments);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.auth_login, null);
        mDialog=(SimpleArcLoader)findViewById(R.id.loader);


        fragments.addView(v);
        phone=(EditText) v.findViewById(R.id.phone);
        pass1=(EditText) v.findViewById(R.id.pass1);
        login_btn=(MyButton)v.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!phone.getText().toString().isEmpty()&&!pass1.getText().toString().isEmpty()){
                Login();

                }else{
                    Toast.makeText(getApplicationContext(),"fill all field",Toast.LENGTH_LONG).show();


                }
            }
        });
        signup_btn=(MyButton)v.findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Activity_Rigister.class));
            }
        });
    }


    private void Login()
    {
       // pdDialog.show();
        dialog = new ACProgressFlower.Builder(context)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .text("Logining wait")
                .fadeColor(Color.DKGRAY).build();
        dialog.show();
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("anyText",response);
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            String message = jsonObject.getString("message");

                            if(success.equals("1")){
                                String user_id= jsonObject.getString("user_id");
                                String user_name = jsonObject.getString("user_name");
                                String email = jsonObject.getString("email");
                                String password = jsonObject.getString("password");
                                String phone = jsonObject.getString("phone");
                                Toast.makeText(getApplicationContext(),"Logged In  Success",Toast.LENGTH_LONG).show();
                              //  pdDialog.dismiss();
                                AppController.getInstance().loginUser(user_name,email,password,phone);
                                fragments.removeAllViews();
                                Intent i = new Intent(getApplication(),MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            if(success.equals("0")){
                                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                                //pdDialog.dismiss();
                            }
                            if(success.equals("3")){
                                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                               // pdDialog.dismiss();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Registration Error !1"+e,Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                       //mDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // pdDialog.dismiss();
               // mDialog.dismiss();
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Registration Error !2"+error,Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("Phone",phone.getText().toString().trim());
                params.put("password",pass1.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
