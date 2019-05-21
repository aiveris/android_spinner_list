package com.example.spinnerlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinner1;
    String[] games;
    List<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);

        games = getResources().getStringArray(R.array.games);

        countries = new ArrayList<String>();
        countries.add("Lithuania");
        countries.add("Latvia");
        countries.add("Estonia");
        countries.add("Poland");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,games );
        spinner.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countries );
        spinner1.setAdapter(adapter1);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Spinner", "Selected " + games[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner1.setSelection(0,false);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.e("Spinner1", "Selected " + countries.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    public void resultsCLick(View v){
        countries.add("Other");// advantange of adapter, dynamic adds

        Log.e("RESULTS", "GAME " + spinner.getSelectedItem().toString() + " | " + spinner.getSelectedItemPosition());//use index position to know if any selection was made
        Log.e("RESULTS", "COUNTRY " + spinner1.getSelectedItem().toString() + " | " + spinner1.getSelectedItemPosition());// or is it still stuck on position 0 ie "-----"
    }

    public void gotoList(View v){
        Intent i = new Intent(this, Main2Activity.class );
        startActivity(i);
    }
}
