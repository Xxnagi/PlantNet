package com.example.plantnet.communitymain.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.plantnet.R;
import com.example.plantnet.community_detail.test;

import java.util.ArrayList;

public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {

    private ArrayList<Communities> communities = new ArrayList<>();
    private Context context;
    public Recyclerview1Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_community_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.CommunityName.setText(communities.get(position).getName());
        Glide.with(holder.itemView.getContext())
                .load(communities.get(position).getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.CommunityLogo);
        holder.parent.setOnClickListener(v -> {
            // Create an Intent to start the new activity
            Intent intent = new Intent(context, test.class);
            // Pass any data you want to the new activity
            intent.putExtra("community_name", communities.get(position).getName());
            intent.putExtra("image_url", communities.get(position).getImageUrl());
            // Start the new activity
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return communities.size();
    }

    public void setCommunities(ArrayList<Communities> communities) {
        this.communities = communities;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView CommunityLogo;
        private TextView CommunityName;
        private RelativeLayout parent;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            CommunityLogo = itemView.findViewById(R.id.CommunityLogo);
            CommunityName = itemView.findViewById(R.id.CommunityName);
            parent = itemView.findViewById(R.id.communityWrapper);
        }
    }
}
