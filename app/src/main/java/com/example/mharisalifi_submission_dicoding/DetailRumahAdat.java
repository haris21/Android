package com.example.mharisalifi_submission_dicoding;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailRumahAdat extends AppCompatActivity {
    public static final String ASAL = "Asal Rumah Adat";
    public static final String NAMA = "Nama Rumah";
    public static final String GAMBAR = null;
    public static final String DESC = "Desc Rumah Adat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rumah_adat);

        String nm_rmh_adat = getIntent().getStringExtra(NAMA);
        String asl_rmh_adat = getIntent().getStringExtra(ASAL);
        String ambil_alamt_gambar = getIntent().getStringExtra(GAMBAR);
        String ket = getIntent().getStringExtra(DESC);
        setTitle("Detail Rumah Adat "+nm_rmh_adat);

        TextView desc_rmh_adat = findViewById(R.id.desc_rmhadat);
        desc_rmh_adat.setText(ket);

        TextView asal = findViewById(R.id.asl_rmhadat);
        asal.setText(asl_rmh_adat);

        TextView nama = findViewById(R.id.nm_rmhadat);
        nama.setText(nm_rmh_adat);

//        Toast.makeText(this, ket, Toast.LENGTH_SHORT).show();

        ImageView gmbr = findViewById(R.id.img_detail_rmh);
        Glide.with(this)
                .load(ambil_alamt_gambar)
                .into(gmbr);


    }
}