package com.ourcoaching.simplespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private String[] cities;
    private ArrayAdapter<String> arrayAdapter;

    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);

        cities=new String[4];
        cities[0]="Delhi";
        cities[1]="Mumbai";
        cities[2]="Chennai";
        cities[3]="Kolkata";

        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cities);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        int spinner_id;
        spinner_id=adapterView.getId();

        switch (spinner_id){

            case R.id.spinner:
                Toast.makeText(this,cities[i],Toast.LENGTH_SHORT).show();
                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}