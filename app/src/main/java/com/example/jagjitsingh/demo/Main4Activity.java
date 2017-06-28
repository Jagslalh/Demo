package com.example.jagjitsingh.demo;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.net.URI;

public class Main4Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Button b1,b2;
    ImageButton imageButton;
    Button chat_button;
    public static int iop =2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Button chat_button= (Button)findViewById(R.id.chat_button);
        chat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Chat_Employer.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu maine) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maine, maine);
        return super.onCreateOptionsMenu(maine);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

int id = item.getItemId();
        if  (id == R.id.settings)
        {
        Intent j = new Intent(this,Main6Activity.class);
            startActivity(j);

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.check_in)
        {
            Intent i = new Intent(getApplicationContext(),Check_in.class);
            startActivity(i);

        } else if (id == R.id.crm) {

        } else if (id == R.id.brochure) {

        } else if (id == R.id.attendance_reports) {

        } else if (id == R.id.checkin_reports) {

        }
        else if (id == R.id.Dsr_reports)
        {

        }

        else if (id ==R.id.expenses_reports)
        {

        }
        else if (id == R.id.tracking)
        {

        }
        else if (id == R.id.share)
        {
             ApplicationInfo d = new ApplicationInfo(getApplicationInfo());
             String s= d.sourceDir;
             Intent i = new Intent(Intent.ACTION_SEND);
             i.setType("*/*");
             i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(s)));
             startActivity(Intent.createChooser(i,"Share"));

        }

        else  if (id == R.id.invite)

        {
            Intent o = new Intent(Intent.ACTION_SEND);
            o.setType("text/plain");
            o.putExtra(Intent.EXTRA_TEXT,"Download This app From Google Play Store \n \n https://play.google.com/store/apps/details?id=com.whatsapp&hl=en");
            startActivity(o);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
