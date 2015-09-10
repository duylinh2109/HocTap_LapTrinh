package com.example.duylinh2109.demolistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayDeque;

/**
 * Created by duylinh2109 on 9/9/2015.
 */
public class demoLstViewActivity extends Activity {

    private ListView lvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlstview);

        //dua du lieu vao mang
        String[] countries= getResources().getStringArray(R.array.countries);

        //lay listview thong qua id
        lvCountry= (ListView)findViewById(R.id.demolstView);

        //tao doi tuong ArrayAdapter va dua du lieu tu mang vao Adapter
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);

        //do lu lieu len listview
        lvCountry.setAdapter(adapter);

        ShowLogWhenClickItemOfList();

    }

    public void ShowLogWhenClickItemOfList()
    {
        lvCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //xuat ra vi tri item duoc click tren listview

                Toast.makeText(demoLstViewActivity.this,"OnItemClick: Pos: "+ position+ " ID: "+id, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
