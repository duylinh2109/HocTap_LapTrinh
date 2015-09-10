package com.example.duylinh2109.thuchanh_customlistview;

import android.app.Activity;
import android.content.Context;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by duylinh2109 on 9/9/2015.
 */
public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context=null;
    ArrayList<Employee> arr= null;
    int layoutId;

    public MyArrayAdapter(Activity _context, int _layoutId, ArrayList<Employee> _arr)
    {
        super(_context,_layoutId,_arr);
        this.context= _context;
        this.layoutId= _layoutId;
        this.arr=_arr;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        convertView = inflater.inflate(layoutId, null);

        if (arr.size() > 0 && position >= 0)
        {
            //Lay textview de hien thi ma len tren
            final TextView txtDisplay= (TextView)convertView.findViewById(R.id.txt_item);
            final Employee emp= arr.get(position);
            txtDisplay.setText(emp.toString());
            final ImageView imgView= (ImageView)convertView.findViewById(R.id.imgitem);
            if(emp.isGender())
                imgView.setImageResource(R.drawable.girlicon);
            else
                imgView.setImageResource(R.drawable.boyicon);
        }
        return convertView;
    }
}
