package com.example.duylinh2109.thuchanh_customlistview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class MainActivity extends Activity {

    ArrayList<Employee> arrEmployee;
    MyArrayAdapter adapter=null;
    ListView lvNhanVien=null;

    Button btnNhap;
    EditText edtMaNV,edtTenNV;
    ImageButton btnRemoveAll;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap= (Button)findViewById(R.id.btnNhap);
        btnRemoveAll= (ImageButton)findViewById(R.id.imgBtnDel);
        edtMaNV= (EditText)findViewById(R.id.edt_manhanvien);
        edtTenNV= (EditText)findViewById(R.id.edt_tennhanvien);
        genderGroup= (RadioGroup)findViewById(R.id.radioGroup1);
        lvNhanVien= (ListView)findViewById(R.id.lvNhanVien);

        arrEmployee= new ArrayList<Employee>();

        adapter= new MyArrayAdapter(this,R.layout.my_item_layout, arrEmployee);

        lvNhanVien.setAdapter(adapter);


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhap();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa();
            }
        });

    }

    public void xuLyNhap()
    {
        String ma= edtMaNV.getText()+"";
        String ten= edtTenNV.getText()+"";
        boolean gt=false; //Nam=false
        if(genderGroup.getCheckedRadioButtonId()==R.id.rdb_nu)
            gt=true;

        //Create object Employee
        Employee emp= new Employee();
        emp.setId(ma);
        emp.setName(ten);
        emp.setGender(gt);

        arrEmployee.add(emp);
        adapter.notifyDataSetChanged();

        edtTenNV.setText("");
        edtMaNV.setText("");
        edtMaNV.requestFocus();
    }

    public void xuLyXoa()
    {
        //duyet nguoc tu cuoi danh sach len dau danh sach
        for(int i= lvNhanVien.getChildCount()-1;i>=0; i-- )
        {
            View v= lvNhanVien.getChildAt(i);
            CheckBox chkbox= (CheckBox)v.findViewById(R.id.chkitem);

            if(chkbox.isChecked())
                arrEmployee.remove(i);
        }
        adapter.notifyDataSetChanged();
    }
}
