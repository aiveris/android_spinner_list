package com.example.spinnerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView list1;
    ListView list2;
    List<String> selections;
    String[] games;

    ArrayAdapter<String> adapter1, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);

        games = getResources().getStringArray(R.array.games);
        selections = new ArrayList<String>();

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, games );
        list1.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, selections );
        list2.setAdapter(adapter2);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("LIST 1", "Selected: " + games[position]);

                selections.add(games[position]);
                adapter2.notifyDataSetChanged();
            }
        });

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("LIST 2", "CLICKED on: " + selections.get(position));

            }
        });

        list2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("LIST 2", "LONG clicked on: " + selections.get(position));

                selections.remove(position);
                adapter2.notifyDataSetChanged();

                return true;
            }
        });


    }
}
