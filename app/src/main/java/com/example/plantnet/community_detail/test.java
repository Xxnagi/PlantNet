package com.example.plantnet.community_detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.plantnet.R;
import com.example.plantnet.community_detail.staggered_grid.Posts;
import com.example.plantnet.community_detail.staggered_grid.PostsAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_detail);

        ImageView imageView = findViewById(R.id.CommunityLogo);
        TextView textView = findViewById(R.id.communityName);
        TabItem tabPosts = findViewById(R.id.tabPosts);
        TabItem tabAbout = findViewById(R.id.tabAbout);
        RecyclerView viewPost = findViewById(R.id.viewPost);
        View viewAbout = findViewById(R.id.viewAbout);
        TabLayout tabLayout = findViewById(R.id.communityTab);

        // Retrieve data from the intent
        String communityName = getIntent().getStringExtra("community_name");
        String imageUrl = getIntent().getStringExtra("image_url");

        // Set the data to the views
        textView.setText(communityName);
        Glide.with(this).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPost.setVisibility(View.VISIBLE);
                        viewAbout.setVisibility(View.GONE);
                        break;
                    case 1:
                        viewPost.setVisibility(View.GONE);
                        viewAbout.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(@NonNull TabLayout.Tab tab) {
                // Do nothing
            }

            @Override
            public void onTabReselected(@NonNull TabLayout.Tab tab) {
                // Do nothing
            }
        });

        viewPost.setHasFixedSize(true);
        List<Posts> posts = new ArrayList<>();
        posts.add(new Posts(R.drawable.a));
        posts.add(new Posts(R.drawable.b));
        posts.add(new Posts(R.drawable.c));
        posts.add(new Posts(R.drawable.d));
        posts.add(new Posts(R.drawable.e));
        posts.add(new Posts(R.drawable.a));
        posts.add(new Posts(R.drawable.b));
        posts.add(new Posts(R.drawable.c));
        posts.add(new Posts(R.drawable.d));
        posts.add(new Posts(R.drawable.e));


        viewPost.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        PostsAdapter adapter = new PostsAdapter(test.this, posts);
        viewPost.setAdapter(adapter);
    }
}
