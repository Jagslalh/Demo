package com.example.jagjitsingh.demo;

import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login;

public class Maps1Activity extends ActionBarActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button register;
    Button kl;
    sign_up_data p;
    EditText a, b, c, d1, e, f1, g, h, i, z;
Toolbar toolbar1;
    CheckBox checkBox;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        AlertDialog.Builder ab = new AlertDialog.Builder(Maps1Activity.this);
        ab.setTitle("Register as a ");
        ab.setCancelable(false);
        ab.setPositiveButton("Employer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Maps1Activity.this, "", Toast.LENGTH_SHORT);
            }
        });

        ab.setNegativeButton("Employee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog ad = ab.create();
        ad.show();

        p = new sign_up_data(getApplicationContext());
        register = (Button) findViewById(R.id.register);

        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (EditText) findViewById(R.id.c);
        d1 = (EditText) findViewById(R.id.d1);
        e = (EditText) findViewById(R.id.e);
        f1 = (EditText) findViewById(R.id.f1);
        g = (EditText) findViewById(R.id.g);
        h = (EditText) findViewById(R.id.h);
        i = (EditText) findViewById(R.id.i);
        z = (EditText) findViewById(R.id.z);
        kl =(Button)findViewById(R.id.kl);
        checkBox =(CheckBox)findViewById(R.id.checkbox);
        add();
        show();


    }


    void add() {





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                    boolean f = p.newinsert(a.getText().toString(), b.getText().toString(),c.getText().toString(),d1.getText().toString(),e.getText().toString(),f1.getText().toString(),g.getText().toString(),h.getText().toString(),i.getText().toString(),z.getText().toString());

                    if (f == true) {
                        Toast.makeText(Maps1Activity.this, "Ho Gya", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Maps1Activity.this, "nhi Hoyea", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }



    public void show()
    {

        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Cursor d = p.get("1", a.getText().toString(), b.getText().toString(), c.getText().toString(), d1.getText().toString(), e.getText().toString(), f1.getText().toString(), g.getText().toString(), h.getText().toString(), i.getText().toString(), z.getText().toString());

                    if (d.getCount() == 0) {
                        show("Error", "no data");
                        return;
                    }

                    StringBuffer b = new StringBuffer();
                    while (d.moveToNext()) {
                        b.append("ID:" + d.getString(0));
                        b.append("organization:  " + d.getString(1) + "\n");
                        b.append("firstname:  " + d.getString(2) + "\n");
                        b.append("lastname:  " + d.getString(3) + "\n");
                        b.append("emailid:  " + d.getString(4) + "\n");
                        b.append("password:  " + d.getString(5) + "\n");
                        b.append("mobileno:  " + d.getString(6) + "\n");
                        b.append("address:  " + d.getString(7) + "\n");
                        b.append("business:  " + d.getString(8) + "\n");
                        b.append("business:  " + d.getString(9) + "\n");
                        b.append("noofemp:  " + d.getString(10) + "\n");


                    }
                    show("Data", b.toString());


            }
        });
    }
        public void show(String title,String message)
        {
            AlertDialog.Builder b=new AlertDialog.Builder(this);
            b.setCancelable(true);
            b.setTitle(title);
            b.setMessage(message);
            b.show();
        }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);


    }


}
