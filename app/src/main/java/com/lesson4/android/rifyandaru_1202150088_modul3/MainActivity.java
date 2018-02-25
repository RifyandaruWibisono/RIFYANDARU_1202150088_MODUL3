package com.lesson4.android.rifyandaru_1202150088_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mMenuAir;
    private ArrayList<Air> mAirData;
    private AdapterAir mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();

//        mangambil id recycler view dari layout menumakan
        mMenuAir = (RecyclerView) findViewById(R.id.recyclerView);
//         Mengambil data grid column dari intergers
        int gridColumn = getResources().getInteger(R.integer.grid_column_count);
//      set manjadi Grid Layout Manager
        mMenuAir.setLayoutManager(new GridLayoutManager(this, gridColumn));
        // membuat array list objek menu untuk menyimpan String dan image
        mAirData = new ArrayList<>();


//      membuat adapter untuk recycler view
        mAdapter = new AdapterAir(this, mAirData);

        mMenuAir.setAdapter(mAdapter);
        initializeData();

    }

    //Get the resources from the XML file
//        mengambil array yang berada pada list string
    private void initializeData() {
        String[] airList = getResources().getStringArray(R.array.labels_array_item);
        String[] airInfo = getResources().getStringArray(R.array.labels_array_info);
        TypedArray airImageResource = getResources().obtainTypedArray(R.array.labels_array);

        mAirData.clear();

        //memasukkan String dan Image id ke Array list Menu objek
        for (int i = 0; i < airList.length; i++) {
            mAirData.add(new Air(airList[i], airInfo[i], airImageResource.getResourceId(i, 0)));
        }
//Recycle the typed array
        airImageResource.recycle();
//notifkasi perubahan ppada adapter dan menggunakan adaptr pada recycler view
        mAdapter.notifyDataSetChanged();

    }

}
