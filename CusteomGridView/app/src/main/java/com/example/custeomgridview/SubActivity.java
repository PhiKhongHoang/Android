package com.example.custeomgridview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {
    TextView txt_subtensp, txt_subgiasp;
    ImageView img_subitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        img_subitem = findViewById(R.id.img_subitem);
        txt_subtensp = findViewById(R.id.txt_subtensp);
        txt_subgiasp = findViewById(R.id.txt_subgiasp);
//        nhận intent
        Intent myintent = getIntent();
        int image = myintent.getIntExtra("image", 0);
        img_subitem.setImageResource(image);

        String name = myintent.getStringExtra("name");
        txt_subtensp.setText(name);

        int price = myintent.getIntExtra("price", 0);
        txt_subgiasp.setText("Giá sp: " + price);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}