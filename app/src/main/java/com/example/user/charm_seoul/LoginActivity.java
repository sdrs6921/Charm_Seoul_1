package com.example.user.charm_seoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(LoginActivity.this, "login Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "login Failed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
