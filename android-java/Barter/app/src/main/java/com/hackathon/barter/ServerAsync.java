package com.hackathon.barter;

import android.os.AsyncTask;

import com.hackathon.barter.listeners.OnFeedBackListener;
import com.hackathon.barter.web.WebClient;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Charlton on 5/2/2015.
 */
public class ServerAsync extends AsyncTask<Object, Object, Object>{

    private OnFeedBackListener listener;

    public ServerAsync(OnFeedBackListener listener, String param_type){

        this.listener = listener;
        this.param_type = param_type;
    }
    @Override
    protected Object doInBackground(Object... params) {
        WebClient webClient = new WebClient();
        try {
            String feedBack = webClient.makegetRequest(Global.url + params[0].toString().replace(" ","%20"));
            JSONObject jsonObject = new JSONObject(feedBack);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    String param_type;
    @Override
    protected void onPostExecute(Object o) {
        if(o == null){

        }else if(o instanceof JSONObject){
            JSONObject obj = (JSONObject)o;
                if (param_type == "signup") {
                    try {
                        switch (obj.getString("status_message")) {
                            case "error":
                                listener.OnSignUpFail("That user already exist!");
                                break;
                            case "success":
                                listener.OnSignupSuccess(obj);
                                break;
                            case "critical":
                                listener.OnSignUpFail("Username or password is incorrect");
                                break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }else if(param_type == "signin"){
                    try {
                        switch (obj.getJSONObject("data").getString("success")) {
                            case "false":
                                listener.OnLoginFail("Password Or Username is incorrect");
                                break;
                            case "true":
                                listener.OnLoginSuccess(obj.getJSONObject("data"));
                                break;

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{

                }
        }
        super.onPostExecute(o);
    }
}
