package com.mvvm.mvvm.data;

import com.mvvm.mvvm.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
