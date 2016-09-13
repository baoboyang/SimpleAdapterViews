package com.example.karlmorris.simpleadapterviews;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] strings = {"Red", "Green", "Blue", "Indigo"};

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                strings);

        spinner.setAdapter(adapter);

        listView.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                showMessage(parent, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showMessage(parent, position);
            }
        });


    }


    private void showMessage(AdapterView parent, int position){
        String color = parent.getItemAtPosition(position).toString();

        Toast.makeText(MainActivity.this, color, Toast.LENGTH_SHORT).show();
    }
}
