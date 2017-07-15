package com.example.luantran.customlisview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luan tran on 7/15/2017.
 */

public class ListAdapter extends ArrayAdapter<SinhVien> {
    // khi khai bao mot list apdapter là phai khai báo màn hình đang đứng ,  layout , và cái mảng gì
    public ListAdapter(Context context, int resource, List<SinhVien> items) {
        super(context, resource, items);
    }


    // getview tra về view , view trả về giao diện từng dòng
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            // LayoutInflate làm công việc chuyển mã từ một file layout xml lên view.
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_dong_sinh_vien, null);
        }
        SinhVien p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txt = (TextView) view.findViewById(R.id.tv);
            txt.setText(p.HoTen);
            TextView txt1 = (TextView) view.findViewById(R.id.tv1);
            txt1.setText(String.valueOf(p.NamSinh));


        }
        return view;
    }


}
