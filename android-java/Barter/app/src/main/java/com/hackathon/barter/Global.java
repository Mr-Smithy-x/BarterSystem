package com.hackathon.barter;

import android.app.Activity;
import android.content.SharedPreferences;

import com.gc.materialdesign.widgets.SnackBar;
import com.google.gson.Gson;
import com.hackathon.barter.structs.MyItems;
import com.hackathon.barter.structs.Profile;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlton on 5/2/2015.
 */
public class Global {
    public static String url="http://192.168.156.155/";
    private static SharedPreferences sharedPreferences;

    public static SnackBar SnackToast(Activity activity, String message, float size, int timer){
        SnackBar snackBar = new SnackBar(activity, message);
        snackBar.setMessageTextSize(size);
        snackBar.setDismissTimer(timer);
        return snackBar;
    }

    public static void saveUserProfile(String user, String email, String pass, int age) throws JSONException {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("pass", pass);
        jsonObject.put("email", email);
        jsonObject.put("age", age);
        editor.putString("profile", jsonObject.toString());
        editor.apply();
    }

    public static Profile getSavedUserProfile() throws JSONException {
        String obj = getSharedPreferences().getString("profile", "");
        if(obj.length() > 0){
            JSONObject json = new JSONObject(obj);
            String user, email, pass;
            int age;
            user = json.getString("user");
            pass = json.getString("pass");
            email = json.getString("email");
            age = json.getInt("age");
            return new Profile(user,pass,email,age, new ArrayList<MyItems>());
        }
        return null;
    }



    public static SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }

    public static void setPreferences(SharedPreferences sharedPreferences){
        Global.sharedPreferences = sharedPreferences;
    }
}
