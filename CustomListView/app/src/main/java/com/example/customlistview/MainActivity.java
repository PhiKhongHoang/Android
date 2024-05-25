package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.ss, R.drawable.ip, R.drawable.htc, R.drawable.oppo, R.drawable.bphone};
    String name[] = {"ss", "ip", "htc", "oppo", "bphone"};
//    khai báo istview
    ArrayList<Phone> mylist;
    MyArrayAdapter myArrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>(); // tạo mới mảng rỗng
        for(int i=0; i<name.length; i++){
            mylist.add(new Phone(image[i], name[i]));
        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, mylist);
        lv.setAdapter(myArrayAdapter);

//        xử lý click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", name[position]);
                startActivity(myintent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}