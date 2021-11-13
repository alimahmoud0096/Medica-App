package com.elprog.midica.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elprog.midica.R;
import com.elprog.midica.model.Doctor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class customRecyclerDoctors extends RecyclerView.Adapter<customRecyclerDoctors.MyViewHolder> {

    private List<Doctor> doctors;

    // Pass in the contact array into the constructor
    public customRecyclerDoctors(List<Doctor> doctorss) {
        doctors = doctorss;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView doc_img;

        public TextView doc_name_tv, doc_name_t, price_tv, speciality_desc_tv, price_range_tv, desc_tv, rate_tv;
        public Button book_btn;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public MyViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            doc_img=(ImageView)itemView.findViewById(R.id.doc_img);
            doc_name_tv = (TextView) itemView.findViewById(R.id.doc_name_tv);
            price_tv = (TextView) itemView.findViewById(R.id.price_tv);
            speciality_desc_tv = (TextView) itemView.findViewById(R.id.speciality_desc_tv);
            price_range_tv = (TextView) itemView.findViewById(R.id.price_range_tv);
            desc_tv = (TextView) itemView.findViewById(R.id.desc_tv);
            rate_tv = (TextView) itemView.findViewById(R.id.rate_tv);
            book_btn = (Button) itemView.findViewById(R.id.book_btn);
        }
    }

    @NonNull
    @Override
    public customRecyclerDoctors.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.doctor_item, parent, false);

        // Return a new holder instance
        MyViewHolder viewHolder = new MyViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull customRecyclerDoctors.MyViewHolder holder, int position) {


        Doctor doctor = doctors.get(position);

        // Set item views based on your views and data model
        try {
            Picasso.get().load(doctor.getImage()).into(holder.doc_img);
            holder.doc_name_tv.setText(doctor.getDoctor_name());
            holder.price_tv.setText(doctor.getDoctor_price());
            holder.speciality_desc_tv.setText(doctor.getDoctor_email());
            holder.price_range_tv.setText(doctor.getDoctor_name());
            holder.desc_tv.setText(doctor.getDoctor_address());
            holder.rate_tv.setText("5");
        }catch (Exception e){}
        //holder.book_btn.
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }
}
