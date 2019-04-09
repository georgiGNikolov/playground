package com.example.skeleton;

import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

        private static final int TIMEOUT = 30;
        private static RetrofitManager retrofitManager;
        private Retrofit retrofit;

        private RetrofitManager(){}

        public static RetrofitManager getInstance() {
            if (retrofitManager == null) {
                retrofitManager = new RetrofitManager();
            }
            return retrofitManager;
        }

        Retrofit provideRetrofit() {
            return retrofit;
        }


        public void init(String url) {
            retrofit = provideRetrofit(url, provideOkHttpClient());
        }


        private Retrofit provideRetrofit(String endpoint, OkHttpClient okHttpClient) {

            return new Retrofit.Builder()
                    .baseUrl(endpoint)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        private OkHttpClient provideOkHttpClient() {

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            return new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .build();
        }
}
