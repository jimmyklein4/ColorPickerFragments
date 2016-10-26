package edu.temple.colorpickerfragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jimmyklein on 9/22/16.
 */

public class ColorPicker extends BaseAdapter {

    private String[] colors;
    private final String TAG = "ColorPicker";
    private Context context;

    public ColorPicker(Context context, String[] colors){

        this.colors = colors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LinearLayout layout;

        if(convertView!=null){
            layout = (LinearLayout) convertView;
            TextView t = (TextView) layout.getChildAt(0);
            t.setText(colors[position]);

        } else {
            layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            TextView colorTextView = new TextView(context);
            colorTextView.setText(colors[position]);
            colorTextView.setBackgroundColor(Color.parseColor(colors[position]));

            layout.addView(colorTextView);
        }

        return layout;
    }


}
