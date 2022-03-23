package com.example.projectdicoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView foto;
    private TextView nama, judul, rilis, lirik;
    private ImageButton spotify;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        foto = findViewById(R.id.img_item_photo2);
        nama = findViewById(R.id.tv_name2);
        judul = findViewById(R.id.tv_judulLagu2);
        rilis = findViewById(R.id.tv_tahunRilis);
        lirik = findViewById(R.id.tv_Lirik);
        spotify = findViewById(R.id.spotify);
        spotify.setOnClickListener(this);

        String name1 = getIntent().getStringExtra("nama");
        String judul1 = getIntent().getStringExtra("judul");
        String rilis1 = getIntent().getStringExtra("rilis");
        String lirik1 = getIntent().getStringExtra("lirik");
        Bundle foto1 = getIntent().getExtras();

        nama.setText(name1);
        judul.setText(judul1);
        rilis.setText(rilis1);
        lirik.setText(lirik1);
        int poto = foto1.getInt("gambar");
        foto.setImageResource(poto);

        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.spotify){
            Uri uriUrl = Uri.parse(getIntent().getStringExtra("link"));
            Intent moveLink = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(moveLink);

        }
    }
}