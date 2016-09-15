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

import java.util.ArrayList;

public class MainActivity extends Activity {

    boolean firstLoadSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] array = {"Apples", "Oranges", "Pears", "Peaches"};

        ArrayAdapter adapter = new ArrayAdapter(this
                , android.R.layout.simple_spinner_dropdown_item
                , array);


        ArrayList<Item> items = new ArrayList<>();


        // Test items
        items.add(new Item("Honda", "Accord"));
        items.add(new Item("Subaru", "Impreza"));
        items.add(new Item("Ford", "Explorer"));
        items.add(new Item("Toyota", "Camry"));

        ItemAdapter itemAdapter = new ItemAdapter(this, items);

        listView.setAdapter(itemAdapter);
        spinner.setAdapter(itemAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!firstLoadSelection)
                    showMessage(parent, position);
                firstLoadSelection = false;
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
        String message = ((Item) parent.getItemAtPosition(position)).getName();
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
