package com.example.karlmorris.simpleadapterviews;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter{

    ArrayList<Item> items;
    Context c;

    public ItemAdapter (Context c, ArrayList<Item> items){
        this.c = c;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View oldView, ViewGroup parent) {
        LinearLayout layout;

        if (oldView != null) {
            layout = (LinearLayout) oldView;

            TextView name = (TextView) layout.getChildAt(0);
            TextView description = (TextView) layout.getChildAt(1);

            name.setText(items.get(position).getName());
            description.setText(items.get(position).getDescription());
        } else {
            layout = new LinearLayout(c);
            layout.setOrientation(LinearLayout.VERTICAL);
            TextView nameTextView = new TextView(c)
                    , descriptionTextView = new TextView(c);

            nameTextView.setText(items.get(position).getName());
            descriptionTextView.setText(items.get(position).getDescription());


            nameTextView.setTextSize(25);
            descriptionTextView.setTextSize(15);

            nameTextView.setTextColor(Color.BLACK);
            descriptionTextView.setTextColor(Color.BLACK);

            layout.addView(nameTextView);
            layout.addView(descriptionTextView);
        }


        return layout;
    }
}
