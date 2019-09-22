package com.example.minimoneybox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserAccountActivity : AppCompatActivity() {

    lateinit var t: TextView
    lateinit var result: TextView
    lateinit var st: String
    val USER_NAME = "userName"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        st = intent.getStringExtra(USER_NAME)
        setupViews()
//        getResults()


    }

    private fun setupViews() {
        result = findViewById(R.id.result)
        var text = getString(R.string.userAccountWelcome, st)
        t = findViewById(R.id.btn_sign_in)
        t.setText(text)
    }
//
//    private fun getResults() {
//        var retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://api-test01.moneyboxapp.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        var jsonHolder = retrofit.create(JsonHolder::class.java)
//        var call = jsonHolder.postLogin()
//        val callback = Callback<List<RetrofitCore>>
//        call.enqueue(callback : Callback<List<RetrofitCore>>{
//            override fun onFailure(call: Call<JsonHolder>?, t: Throwable?) {
//                Log.v("retrofit", "call failed")
//            }
//
//            override fun onResponse(call: Call<JsonHolder>?, response: Response<JsonHolder>?) {
//
//            }
//
//        }
//
//    }
}
