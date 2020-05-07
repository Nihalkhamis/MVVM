package com.mvvm.mvvm.ui.main;

import android.os.Bundle;

import com.mvvm.mvvm.R;
import com.mvvm.mvvm.adapter.PostAdapter;
import com.mvvm.mvvm.models.PostModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    @BindView(R.id.postRV)
    RecyclerView postRV;

    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postAdapter = new PostAdapter();

        postViewModel.getPosts();

        postRV.setLayoutManager(new LinearLayoutManager(this));
        postRV.setAdapter(postAdapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setPostModels(postModels);
            }
        });


    }
}
