package com.example.jagjitsingh.demo;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Spinner spinner =(Spinner)findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{



        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }

    }
    Spinner spinner =(Spinner)findViewById(R.id.spinner);



}
