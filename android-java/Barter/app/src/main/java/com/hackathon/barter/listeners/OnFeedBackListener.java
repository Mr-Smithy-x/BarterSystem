package com.hackathon.barter.listeners;

import com.hackathon.barter.structs.MyItems;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Charlton on 5/2/2015.
 */
public interface OnFeedBackListener {
    public void OnSignupSuccess(JSONObject jsonObject);
    public void OnLoginSuccess(JSONObject jsonObject);
    public void OnLoginFail(String message);
    public void OnSignUpFail(String message);
    public void OnItemsLoaded(List<MyItems> myItemsList);
}
