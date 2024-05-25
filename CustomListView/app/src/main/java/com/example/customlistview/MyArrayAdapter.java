package com.example.customlistview;

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

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Phone> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

//    gọi hàm getview để tiến hành sắp xếp dữ liệu
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        tạo đế ể chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
//        đặt idlayout lên đế ddeert ạo thành view
        convertView = myflater.inflate(idLayout, null);
//        lấy 1 phần tử ttrong mảng
        Phone myphone = myList.get(position);
//        khai báo tham chiếu id và hiển thị lên imageview
        ImageView imgphone = convertView.findViewById(R.id.img_phone);
        imgphone.setImageResource(myphone.getImage());
//        tham chiếu id và hiển thị tên
        TextView txtphone = convertView.findViewById(R.id.txt_phone);
        txtphone.setText(myphone.getName());
        return convertView;
    }
}
