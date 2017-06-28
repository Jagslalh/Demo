package com.example.jagjitsingh.demo;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class Main2Activity extends AppCompatActivity
{

    private LoginButton fbLoginButton;
    Button button,button3,button2;
    Button B1;
    Data g;
    EditText E1,E2;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        g =new Data(getApplicationContext());
        button3=(Button)findViewById(R.id.button3);
        E1=(EditText)findViewById(R.id.E1);
        E2 =(EditText)findViewById(R.id.E2);
        button =(Button)findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i);
            }
        });


        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Maps1Activity.class);
                startActivity(i);
            }
        });


        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(this);
        initFacebookAfter();
        add();

    }
    private void initFacebookAfter() {

        fbLoginButton =(LoginButton)findViewById(R.id.login_button);

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                System.out.println("Facebook Login Successful!");
                System.out.println("Logged in user Details : ");
                System.out.println("--------------------------");
                System.out.println("User ID  : " + loginResult.getAccessToken().getUserId());
                System.out.println("Authentication Token : " + loginResult.getAccessToken().getToken());
                Toast.makeText(Main2Activity.this, "Login Successful!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(Main2Activity.this, "Login cancelled by user!", Toast.LENGTH_LONG).show();
                System.out.println("Facebook Login failed!!");

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(Main2Activity.this, "Login unsuccessful!", Toast.LENGTH_LONG).show();
                System.out.println("Facebook Login failed!!");
            }
        });
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent i) {
        callbackManager.onActivityResult(reqCode, resCode, i);
    }

    void add()
    {
       button.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {

               if (E1.getText().toString().length()==0)
               {
                   Snackbar.make(v, "We Need Your Email ", Snackbar.LENGTH_LONG).setAction("Click",null).show();

               }
               if (E2.getText().toString().length()==0)
               {
               Snackbar.make(v,"We Need Your Password For Further Action", Snackbar.LENGTH_LONG).setAction("No",null).show();
               }
               else
               {
                   boolean a = g.insert(E1.getText().toString(), E2.getText().toString());
                   if (a == true) {
                      Intent i = new Intent(getApplicationContext(), Main4Activity.class);
                       startActivity(i);
                   }
                   else
                   {
                       Snackbar.make(v, "DataBase Shi Ni hai Y Tera",10000).setAction("Nothing",null).show();
                   }
               }
           }
       });
    }
}


