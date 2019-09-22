package com.example.minimoneybox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonHolder {
    @GET("investorproducts")
    Call<List<RetrofitCore>> getInvestorProducts();

    @POST("users/login")
    Call<List<RetrofitCore>> postLogin();

    @POST("oneoffpayments")
    Call<List<RetrofitCore>> postOneOffPayments();
}
