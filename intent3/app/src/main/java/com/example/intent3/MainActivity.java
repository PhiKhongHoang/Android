package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtKQ;
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtKQ = findViewById(R.id.edtKQ);
        btnRequest = findViewById(R.id.btnRequest);

//        xử lí click
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
//                lấy dữ iệu
                int a = Integer.parseInt(edtA.getText().toString());
//                đưa dữ iệu vào intent
                myIntent.putExtra("soA", a);
                startActivityForResult(myIntent, 99);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq", 0);
            edtKQ.setText("Giá trị goosc là: " + kq);
        }
        if(requestCode == 99 && resultCode == 34){
            int kq = data.getIntExtra("kq", 0);
            edtKQ.setText("Giá trị bình phương: " + kq);
        }
    }
}