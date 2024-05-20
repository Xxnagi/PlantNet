package com.example.plantnet.communitymain;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantnet.R;
import com.example.plantnet.communitymain.carousel.CaraouselAdapter;
import com.example.plantnet.communitymain.recyclerview.Communities;
import com.example.plantnet.communitymain.recyclerview.Recyclerview1Adapter;
import java.util.ArrayList;

public class CommunityMain extends AppCompatActivity {

    private RecyclerView recyclerview1;
    private RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Capture the original padding of the view
        View mainView = findViewById(R.id.main);
        int originalPaddingLeft = mainView.getPaddingLeft();
        int originalPaddingTop = mainView.getPaddingTop();
        int originalPaddingRight = mainView.getPaddingRight();
        int originalPaddingBottom = mainView.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    originalPaddingLeft,
                    originalPaddingTop + systemBars.top,
                    originalPaddingRight,
                    originalPaddingBottom + systemBars.bottom
            );
            return insets;
        });

        recyclerview1 = findViewById(R.id.recViewCommunityLogo);
        ArrayList<Communities> communities = new ArrayList<>();
        communities.add(new Communities("Orchid Oasis", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        communities.add(new Communities("Sakura", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        communities.add(new Communities("Rose Petals", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        communities.add(new Communities("Monstera Club", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        communities.add(new Communities("Cactus Crew", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        communities.add(new Communities("Tropicl Tribe", "https://i.pinimg.com/236x/a2/c1/87/a2c187d2006f669dd4e6bb894b45cf4e.jpg"));
        Recyclerview1Adapter adapter1 = new Recyclerview1Adapter(this);
        adapter1.setCommunities(communities);
        recyclerview1.setAdapter(adapter1);
        recyclerview1.setLayoutManager(new GridLayoutManager(this, 3));



        recyclerView2 = findViewById(R.id.recycler);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://plus.unsplash.com/premium_photo-1706301015414-f2b62072cbe1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyNXx8fGVufDB8fHx8fA%3D%3D");
        arrayList.add("https://images.unsplash.com/photo-1715630914788-71ec3db8bf6b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyNnx8fGVufDB8fHx8fA%3D%3D");
        arrayList.add("https://images.unsplash.com/photo-1713616467053-c88453ff8320?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyOHx8fGVufDB8fHx8fA%3D%3D");
        arrayList.add("https://images.unsplash.com/photo-1714394692179-022d20b92995?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzMHx8fGVufDB8fHx8fA%3D%3D");
        arrayList.add("https://images.unsplash.com/photo-1715343413411-116c0ec80c08?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzNHx8fGVufDB8fHx8fA%3D%3D");

        CaraouselAdapter adapter = new CaraouselAdapter(CommunityMain.this, arrayList);
        adapter.setOnItemClickListener(new CaraouselAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String url) {
//                startActivity(new Intent(CommunityMain.this, CaraouselViewActivity.class).putExtra("image", url),
//                        ActivityOptions.makeSceneTransitionAnimation(CommunityMain.this, imageView, "image").toBundle());
                Toast.makeText(CommunityMain.this, "selected", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView2.setAdapter(adapter);
    }
}