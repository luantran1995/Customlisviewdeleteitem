package com.example.luantran.customlisview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listview);
        //create arraylist
        final ArrayList<SinhVien> mangsinhvien = new ArrayList<SinhVien>();
        mangsinhvien.add(new SinhVien("a",1995));
        mangsinhvien.add(new SinhVien("b",1995));
        mangsinhvien.add(new SinhVien("c",1995));
        mangsinhvien.add(new SinhVien("d",1995));
        mangsinhvien.add(new SinhVien("e",1995));
        final ListAdapter lst  = new ListAdapter(MainActivity.this,R.layout.activity_dong_sinh_vien,mangsinhvien);
        lv.setAdapter(lst);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Delete");
                a.setMessage("Are you sure you want to delete " );
                a.setNegativeButton("Cancel", null);
                //final int positionToRemove = position;
                a.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mangsinhvien.remove(position);
                        lst.notifyDataSetChanged();
                    }});
                a.show();

            }
        });
    }
}
