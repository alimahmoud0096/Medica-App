package com.elprog.midica.model;

public class Doctor {

    String doctor_id, doctor_name	,doctor_email,	doctor_password	,doctor_phone	,doctor_address	,doctor_price	,image;


    public Doctor() {

    }

    public Doctor( String doctor_id,String doctor_name, String doctor_email, String doctor_password, String doctor_phone, String doctor_address, String doctor_price, String image) {
this.doctor_id=doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_email = doctor_email;
        this.doctor_password = doctor_password;
        this.doctor_phone = doctor_phone;
        this.doctor_address = doctor_address;
        this.doctor_price = doctor_price;
        this.image = image;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    public String getDoctor_password() {
        return doctor_password;
    }

    public void setDoctor_password(String doctor_password) {
        this.doctor_password = doctor_password;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getDoctor_price() {
        return doctor_price;
    }

    public void setDoctor_price(String doctor_price) {
        this.doctor_price = doctor_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
