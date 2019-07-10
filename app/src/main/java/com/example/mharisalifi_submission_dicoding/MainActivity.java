package com.example.mharisalifi_submission_dicoding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRmhAdat;
    private ArrayList<rmh_adat> list = new ArrayList<>();
    private String title = "Rumah Adat Indonesia";

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectRmhAdat(rmh_adat rmhadat) {
//        Toast.makeText(this, "Rumah " + rmhadat.getName(), Toast.LENGTH_LONG).show();
        Intent detailMaster = new Intent(MainActivity.this, DetailRumahAdat.class);
        detailMaster.putExtra(DetailRumahAdat.NAMA, rmhadat.getName());
        detailMaster.putExtra(DetailRumahAdat.ASAL, rmhadat.getFrom());
        detailMaster.putExtra(DetailRumahAdat.GAMBAR, rmhadat.getPhoto());
        detailMaster.putExtra(DetailRumahAdat.DESC,rmhadat.getDesc());
        startActivity(detailMaster);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);


        rvRmhAdat = findViewById(R.id.rv_rmhAdat);
        rvRmhAdat.setHasFixedSize(true);

        list.addAll(rmh_adat_data.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvRmhAdat.setLayoutManager(new LinearLayoutManager(this));
        ListRmhAdatAdapter listRmhAdatAdapter = new ListRmhAdatAdapter(list);
        rvRmhAdat.setAdapter(listRmhAdatAdapter);

        listRmhAdatAdapter.setOnItemClickCallback(new ListRmhAdatAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(rmh_adat data) {
                showSelectRmhAdat(data);
            }
        });
    }


}
