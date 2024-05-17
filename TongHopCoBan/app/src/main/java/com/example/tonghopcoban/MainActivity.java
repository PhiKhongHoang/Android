package com.example.tonghopcoban;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtCMND, edtBoSung;
    Button btnGui;
    RadioGroup idGroup;
    CheckBox chkDocBao, chkDocSach, chkCoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        ánh xạ id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtBoSung);
        btnGui = findViewById(R.id.btnGui);
        idGroup = findViewById(R.id.idgroup);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkCoding = findViewById(R.id.chkCoding);

//        xử lý click vào button gửi
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString();
                if(hoTen.length() < 3) {
                    Toast.makeText(MainActivity.this, "Họ tên phải lớn hơn 2 kí tự", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus(); // đưa con trỏ về đây
                    edtHoTen.selectAll();
                    return;
                }

                String cmnd = edtCMND.getText().toString();
                if(cmnd.length() != 9) {
                    Toast.makeText(MainActivity.this, "CMND phải đúng 9 chữ số", Toast.LENGTH_LONG).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    return;
                }

                int idSelect = idGroup.getCheckedRadioButtonId(); // trả về id của butotn ược chọn trong group
                RadioButton radSelect = findViewById(idSelect);
                String bangCap = radSelect.getText().toString();

                String sothich = "";
                if(chkDocSach.isChecked())
                    sothich += chkDocSach.getText().toString()+" - ";
                if(chkDocBao.isChecked())
                    sothich += chkDocBao.getText().toString()+" - ";
                if(chkCoding.isChecked())
                    sothich += chkCoding.getText().toString();

                String boSung = edtBoSung.getText().toString();

                String tongHop = hoTen + "\n" + cmnd + "\n" + bangCap+ "\n" +sothich+"\n";
                tongHop += "-------- THÔNG TIN BỔ SUNG ----------\n";
                tongHop += boSung+"\n";
                tongHop += "--------------------------------------";

//                tạo dialog và hiển thị thông tin tổng hợp
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                myDialog.create().show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}