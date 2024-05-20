package com.example.plantnet.community_detail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.plantnet.R;

public class PostDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_detail);

        ImageView post = findViewById(R.id.post);
        Button btnDownload = findViewById(R.id.btnDownload);

        int imageResource = getIntent().getIntExtra("image_resource", -1);

        if (imageResource != -1) {
            Glide.with(this).load(imageResource).into(post);
        }

        btnDownload.setOnClickListener(v -> {
            setResult(RESULT_OK, null);
            finish();
        });
    }
}
