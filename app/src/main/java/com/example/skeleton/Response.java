package com.example.skeleton;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
