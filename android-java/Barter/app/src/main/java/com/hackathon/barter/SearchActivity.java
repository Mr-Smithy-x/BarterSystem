package com.hackathon.barter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.hackathon.barter.adapters.SearchAdapter;
import com.hackathon.barter.dialog.PopupItemDialog;
import com.hackathon.barter.listeners.OnFeedBackListener;
import com.hackathon.barter.listeners.OnSearchItemClickedListener;
import com.hackathon.barter.structs.MyItems;
import com.hkm.ui.processbutton.FlatButton;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Charlton on 5/2/2015.
 */
public class SearchActivity extends ActionBarActivity implements View.OnClickListener, OnFeedBackListener, OnSearchItemClickedListener {
    SearchAdapter searchAdapter;
    EditText search_text;
    FlatButton flatButton;
    ListView result_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_text = (EditText) findViewById(R.id.search_text);
        flatButton = (FlatButton) findViewById(R.id.search_btn);
        result_view = (ListView)findViewById(R.id.item_search);
        flatButton.setOnClickListener(this);
        searchAdapter = new SearchAdapter(this, new ArrayList<MyItems>(), this);
        result_view.setAdapter(searchAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.search_btn:
                SearchAsync searchAsync = new SearchAsync(this);
                searchAsync.execute(String.format("?t=%s&item=%s","search",search_text.getText().toString().replace(" ","%20")));
                break;
        }
    }

    @Override
    public void OnSignupSuccess(JSONObject jsonObject) {

    }

    @Override
    public void OnLoginSuccess(JSONObject jsonObject) {

    }

    @Override
    public void OnLoginFail(String message) {

    }

    @Override
    public void OnSignUpFail(String message) {

    }

    @Override
    public void OnItemsLoaded(List<MyItems> myItemsList) {
        searchAdapter.clear();
        for(MyItems myItems : myItemsList){
            searchAdapter.add_item(myItems);
        }
    }

    @Override
    public void OnSearchItemClicked(MyItems myItems, int position) {
        new PopupItemDialog(myItems).show(getSupportFragmentManager(),"");
    }
}
