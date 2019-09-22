package com.example.minimoneybox;

import com.google.gson.annotations.SerializedName;

public class RetrofitCore {
    private String email;
    private String password;
    @SerializedName("idfa")
    private String id;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

}
