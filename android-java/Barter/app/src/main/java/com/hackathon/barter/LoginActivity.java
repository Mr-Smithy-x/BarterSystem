package com.hackathon.barter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.hackathon.barter.listeners.OnFeedBackListener;
import com.hackathon.barter.structs.MyItems;
import com.hackathon.barter.structs.Profile;
import com.hackathon.barter.utils.ProgressGenerator;
import com.hkm.ui.processbutton.iml.ActionProcessButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class LoginActivity extends ActionBarActivity implements ProgressGenerator.OnCompleteListener, OnFeedBackListener {

    EditText user, email, pass;
    ActionProcessButton actionProcessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Global.setPreferences(getSharedPreferences("BARTER", MODE_PRIVATE));
        Profile profile = null;
        try {
            profile = Global.getSavedUserProfile();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        user = (EditText) findViewById(R.id.material_user);
        email = (EditText) findViewById(R.id.material_email);
        pass = (EditText) findViewById(R.id.material_password);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        actionProcessButton = (ActionProcessButton)findViewById(R.id.proccessButton);
        actionProcessButton.setMode(ActionProcessButton.Mode.ENDLESS);

        if(profile != null){
            user.setText(profile.getUser());
            email.setText(profile.getEmail());
            pass.setText(profile.getPass());
            actionProcessButton.setText("Sign In");
        }
        final Profile finalProfile = profile;
        actionProcessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(actionProcessButton);
                if(user.getText().length() > 3 && pass.getText().length() > 3 && email.getText().length() > 8) {
                    try {
                        Global.saveUserProfile(user.getText().toString(),email.getText().toString(),pass.getText().toString(),  19);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(finalProfile == null){
                        ServerAsync serverAsync = new ServerAsync(getFeedBack(), "signup");
                        serverAsync.execute(String.format("?p=%s&u=%s&e=%s&a=%s&t=%s", pass.getText().toString(), user.getText().toString(), email.getText().toString(), 19, "r"));

                    }else{
                        ServerAsync serverAsync = new ServerAsync(getFeedBack(), "signin");
                        serverAsync.execute(String.format("?p=%s&u=%s&e=%s&a=%s&t=%s", pass.getText().toString(), user.getText().toString(), email.getText().toString(), 19, "l"));

                    }
                    //?u=cj&p=window&e=ok&a=19&t=l
                }else{
                    Global.SnackToast(getActivity(), "Empty feilds?", 16,2500).show();
                }
            }
        });
    }

    OnFeedBackListener getFeedBack(){
        return this;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ActionBarActivity getActivity(){
        return this;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void OnSignupSuccess(JSONObject jsonObject) {
        Global.SnackToast(this, jsonObject.toString(), 16, 4000).show();
        launchNextActivity();
    }

    public void launchNextActivity(){
        android.os.Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void OnLoginSuccess(JSONObject jsonObject) {
        Global.SnackToast(this,jsonObject.toString(),16,4000).show();
        launchNextActivity();
    }

    @Override
    public void OnLoginFail(String message) {
        Global.SnackToast(this, message, 16, 4000).show();
    }

    @Override
    public void OnSignUpFail(String message) {
        Global.SnackToast(this, message, 16, 4000).show();

    }

    @Override
    public void OnItemsLoaded(List<MyItems> myItemsList) {

    }
}
