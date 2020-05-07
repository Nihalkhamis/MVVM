package com.mvvm.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvvm.mvvm.R;
import com.mvvm.mvvm.models.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostModel> postModels = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel postModel = postModels.get(position);
        holder.titleTV.setText(postModel.getTitle());
        holder.userIDTV.setText(postModel.getUserId() + "");
        holder.bodyTV.setText(postModel.getBody());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public void setPostModels(List<PostModel> postModels) {
        this.postModels = postModels;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleTV)
        TextView titleTV;
        @BindView(R.id.userIDTV)
        TextView userIDTV;
        @BindView(R.id.bodyTV)
        TextView bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
