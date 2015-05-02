package com.hackathon.barter.structs;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlton on 5/2/2015.
 */
public class Profile {
    String user,pass,email;

    public Profile() {
    }

    public Profile(String user, String pass, String email, int age, List<MyItems> myItemsList) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.age = age;
        this.myItemsList = myItemsList;
    }

    public List<MyItems> getMyItemsList() {
        return myItemsList;
    }

    public void setMyItemsList(List<MyItems> myItemsList) {
        this.myItemsList = myItemsList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    int age;
    List<MyItems> myItemsList = new ArrayList<MyItems>();

}
