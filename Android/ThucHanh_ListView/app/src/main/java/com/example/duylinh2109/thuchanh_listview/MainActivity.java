package com.example.duylinh2109.thuchanh_listview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    EditText edt_Ten;
    TextView txt_Chon;
    Button btn_Nhap;
    ListView lv;
    ArrayList<String> arrList= null;
    ArrayAdapter<String> adapter= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Ten= (EditText)findViewById(R.id.editText);
        txt_Chon= (TextView)findViewById(R.id.textView2);
        btn_Nhap= (Button)findViewById(R.id.button);
        lv= (ListView)findViewById(R.id.lvPerson);
        arrList= new ArrayList<String>();
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrList);
        lv.setAdapter(adapter);

        btn_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrList.add(edt_Ten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt_Chon.setText("Position: "+position+ " Value: "+ arrList.get(position));
            }
        });

        //xu ly su kien long click tren listview, se xoa phan tu do
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
