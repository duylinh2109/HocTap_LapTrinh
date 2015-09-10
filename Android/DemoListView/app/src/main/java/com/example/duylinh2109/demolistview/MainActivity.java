package com.example.duylinh2109.demolistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_demoLv = (Button) findViewById(R.id.btn_demoLv);
        btn_demoLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click Button", Toast.LENGTH_LONG).show();
                RunSecondActivity();
//                Intent intent= new Intent(MainActivity.this,demoLstViewActivity.class);
//                startActivity(intent);
            }
        });
    }

    public void RunSecondActivity()
    {
        Intent intent= new Intent(this,demoLstViewActivity.class);
        startActivity(intent);
    }
}
