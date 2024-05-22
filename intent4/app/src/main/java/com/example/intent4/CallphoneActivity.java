package com.example.intent4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CallphoneActivity extends AppCompatActivity {
    EditText edtphone;
    ImageButton btncall;
    Button btnback1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_callphone);
        edtphone = findViewById(R.id.edtphone);
        btncall = findViewById(R.id.btncall);
        btnback1 = findViewById(R.id.btnback);
//        xử lí click
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                khia báo intent ẩn
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtphone.getText().toString()));
//                yc sự đồng ý của người dùng
                if (ActivityCompat.checkSelfPermission(CallphoneActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallphoneActivity.this, new String[]{android.Manifest.permission.CALL_PHONE},1);
                    return;
                }

                startActivity(callIntent);
            }
        });

        btnback1.setOnClickListener(new View.OnClickListener() {
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