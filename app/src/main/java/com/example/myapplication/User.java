package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private int phonenum;

    public User(){
        super();
    }
    public User(String username,String password,int phonenum){
        super();
        this.username =username;
        this.password =password;
        this.phonenum = phonenum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }
    @Override
    public String toString() {
        return "User [id=" +id +", username=" + username +", password=" + password +", phonenum=" + phonenum +"]";
    }

}
