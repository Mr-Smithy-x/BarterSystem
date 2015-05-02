package com.hackathon.barter;

import android.os.AsyncTask;
import android.util.Log;

import com.hackathon.barter.listeners.OnFeedBackListener;
import com.hackathon.barter.structs.MyItems;
import com.hackathon.barter.web.WebClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Charlton on 5/2/2015.
 */
public class SearchAsync extends AsyncTask<Object, Object, Object> {

    public SearchAsync(OnFeedBackListener onFeedBackListener) {
        this.onFeedBackListener = onFeedBackListener;
    }

    OnFeedBackListener onFeedBackListener;



    @Override
    protected Object doInBackground(Object... params) {
        WebClient webClient = new WebClient();
        try {
            String feedBack = webClient.makegetRequest(Global.url + params[0].toString().replace(" ","%20"));
            JSONArray json = new JSONArray(feedBack);
            return json;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(o != null){
            try {

                JSONArray jsonArray = (JSONArray)o;
                List<MyItems> myItemsList = new ArrayList<MyItems>();
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    MyItems myItems = new MyItems();
                    myItems.setDesc(jsonObject.getString("desc"));
                    myItems.setId(Integer.valueOf(jsonObject.getString("itemid")));
                    myItems.setImg(jsonObject.getString("img"));
                    myItems.setLoc(jsonObject.getString("loc"));
                    myItems.setName(jsonObject.getString("name"));
                    myItems.setOrigin(jsonObject.getString("origin"));
                    myItems.setType(jsonObject.getString("type"));
                    myItems.setOwner(jsonObject.getString("owner"));
                    myItems.setOwnerId(jsonObject.getString("ownerid"));
                    myItemsList.add(myItems);
                }
                onFeedBackListener.OnItemsLoaded(myItemsList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{

            MyItems myItems = new MyItems();
            myItems.setImg("null");
            myItems.setId(1);
            myItems.setOwner("Charlton");
            myItems.setType("Instrument");
            myItems.setDesc("You can buy this guitar");
            onFeedBackListener.OnItemsLoaded(new ArrayList<MyItems>(Arrays.asList(myItems)));

        }
    }
}


