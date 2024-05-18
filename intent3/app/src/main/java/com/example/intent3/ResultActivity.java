package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    EditText edtAA;
    Button btnGoc, btnBinhPhuong;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        edtAA = findViewById(R.id.edtAA);
        btnGoc = findViewById(R.id.btnGoc);
        btnBinhPhuong = findViewById(R.id.btnBinhPhuong);

//        nhận intent
        myIntent = getIntent();
//        lấy dữ liệu ra khỏi intent
        int a = myIntent.getIntExtra("soA", 0);
        edtAA.setText(a + " ");
        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq", a);
                setResult(33, myIntent);
                finish();
            }
        });

        btnBinhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq", a*a);
                setResult(34, myIntent);
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