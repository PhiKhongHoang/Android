package com.example.custeomgridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
//    khgai báo 3 tham số của adapter
    Activity context;
    int idlayout;
    ArrayList<Item> mylist;

    public MyArrayAdapter(Activity context, int idlayout, ArrayList<Item> mylist) {
        super(context, idlayout,mylist);
        this.context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }

    //    gọi hàm getview để adapter lấy và hiển thi dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        tạo để chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
//        đặt idlayout lên đế để tạo view
        convertView = myflater.inflate(idlayout, null);
//        lấy 1 phần tử trong mảng dữ liệu
        Item myitem = mylist.get(position);
//        khai báo ảnh xaj id và hiển thị ảnh của sp
        ImageView imgitem = convertView.findViewById(R.id.img_item);
        imgitem.setImageResource(myitem.getImage());
//        khai ba ánh xạ ifd và hiển thị tên sp
        TextView txttensp  = convertView.findViewById(R.id.txt_tensp);
        txttensp.setText(myitem.getName());
//        khai báo ánh xạ id và hiển thị giá sp
        TextView txtgiasp = convertView.findViewById(R.id.txt_giasp);
        txtgiasp.setText("Giá: " + myitem.getName());
        return convertView;

    }
}
