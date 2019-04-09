package com.example.skeleton;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{user}")
    Call<Response> getInfo(@Path(value = "user",  encoded = true) String user);
}
