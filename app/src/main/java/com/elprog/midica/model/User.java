package com.elprog.midica.model;

public class User {
    String 	user_name	,email	,password		,phone;


    public User() {

    }

    public User(String user_name, String email, String password,  String phone) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;

        this.phone = phone;

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
