package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nghiem;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

//        ánh xạ id
        txt_nghiem = findViewById(R.id.txt_nghiem);
        btnBack = findViewById(R.id.btnBack);

//        nhận intent
        Intent myIntent = getIntent();
//        lấy bundle ra khỏi intent
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
//        lấy dữ liệu khỏi bundle
        int a = myBundle.getInt("soA");
        int b = myBundle.getInt("soB");
//        giải pt
        String nghiem = "";
        if(a == 0 && b == 0){
            nghiem = "pt vô số nghiệm";
        }
        else if(a == 0 && b != 0){
            nghiem = "pt vô nghiệm";
        } else {
            nghiem = "Nghiệm pt = " + (-1.0)*b/a;
        }

        txt_nghiem.setText(nghiem);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}