package com.example.projectdicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvSinger;
    private ArrayList<Singer> list = new ArrayList<>();
    private ImageButton profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSinger = findViewById(R.id.rv_singer);
        rvSinger.setHasFixedSize(true);

        list.addAll(SingerData.getListData());
        showRecyclerList();

        profile = findViewById(R.id.btnProfile);
        profile.setImageResource(R.drawable.aboutprofile);
        profile.setOnClickListener(this);

        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }
    private void showSelectedSinger(Singer singer) {
        Toast.makeText(this, "Kamu memilih " + singer.getNama(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("nama",singer.getNama());
        intent.putExtra("lirik",singer.getlirik());
        intent.putExtra("judul",singer.getJudulLagu());
        intent.putExtra("rilis",singer.getTahunRilis());
        intent.putExtra("gambar", singer.getFoto());
        intent.putExtra("link", singer.getLink());
        startActivity(intent);
    }
    private void showRecyclerList(){
        rvSinger.setLayoutManager(new LinearLayoutManager(this));
        ListSingerAdapter listSingerAdapter = new ListSingerAdapter(list);
        rvSinger.setAdapter(listSingerAdapter);
        listSingerAdapter.setOnItemClickCallback(new ListSingerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Singer data) {
                showSelectedSinger(data);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnProfile){
            Intent move = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(move);
        }

    }
}