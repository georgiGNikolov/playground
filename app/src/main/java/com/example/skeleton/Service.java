package com.example.skeleton;

import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;

public class Service {

    MutableLiveData<Response> liveData = new MutableLiveData<>();


    public LiveData<Response> getLiveData() {
        return liveData;
    }

    public void getInfo(String user) {
        RetrofitManager.getInstance().provideRetrofit().create(ApiService.class).getInfo(user).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
