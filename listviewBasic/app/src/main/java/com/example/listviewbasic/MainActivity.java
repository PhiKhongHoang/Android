package com.example.listviewbasic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    khai báo
    TextView txt_select;
    String myphone[] = {"Samsung", "Oppo", "Iphone", "Nokia", "Bphone"};
    ArrayAdapter<String> myadapter;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt_select = findViewById(R.id.txt_select);
        lv1 = findViewById(R.id.lv1);
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myphone);
        lv1.setAdapter(myadapter);
//        bắt sự kiện click từng item của listview
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt_select.setText("Vị trí: " + position + " " + myphone[position]);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lv1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}