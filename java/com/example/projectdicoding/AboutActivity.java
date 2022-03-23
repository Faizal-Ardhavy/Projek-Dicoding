package com.example.projectdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {
    private ImageView foto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        foto2 = findViewById(R.id.img_item_photo2);
        foto2.setImageResource(R.drawable.profilepic);

        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }
}