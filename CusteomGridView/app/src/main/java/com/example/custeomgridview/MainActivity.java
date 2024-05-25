package com.example.custeomgridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    khai báo các mảng con chứa ảnh tên và giá
    int image[] = {R.drawable.hinh1, R.drawable.hinh2, R.drawable.hinh3, R.drawable.hinh4,
        R.drawable.hinh5, R.drawable.hinh6, R.drawable.hinh7, R.drawable.hinh8};
    String name[] = {"Gậy bẻ lò xo", "Ấm đun siêu tốc", "Tai nghe siêu cấp", "Sữa rửa mặt simple",
                "Tất nam cao cấp", "Quần leggin nam", "Tai nghe bluetooth", "Bơ đào cao cấp"};
    int price[] = {120000, 100000, 170000, 180000, 200000, 300000, 150000, 200000};

//    khia báo gridview
    GridView gv;
    ArrayList<Item> mylist;
    MyArrayAdapter myArrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        tạo mới mnagr chính và ép 3 man con vào mảng chính
        mylist = new ArrayList<>();
        for(int i=0; i<name.length; i++){
            mylist.add(new Item(image[i], name[i], price[i]));
        }
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, mylist);
        gv = findViewById(R.id.gv);
        gv.setAdapter(myArrayAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myinten = new Intent(MainActivity.this, SubActivity.class);
                myinten.putExtra("image", image[position]);
                myinten.putExtra("name", name[position]);
                myinten.putExtra("price", price[position]);
                startActivity(myinten);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}