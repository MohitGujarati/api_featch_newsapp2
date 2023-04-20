package com.example.api_featch_newsapp2

import android.content.ComponentCallbacks
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_featch_newsapp2.Adapter.myAdapter
import com.example.api_featch_newsapp2.Apis.RetroObject
import com.example.api_featch_newsapp2.Model.Article_model
import com.example.api_featch_newsapp2.Model.main_model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {


    lateinit var recview: RecyclerView
    lateinit var adapter: myAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recview = findViewById(R.id.recview)

        getallnews()

    }

    fun getallnews() {
        recview.layoutManager = LinearLayoutManager(this@MainActivity)

        val retrofit = RetroObject.getapi
        val newslist: ArrayList<Article_model> = ArrayList()

        retrofit.getnew().enqueue(object : Callback<main_model> {
            override fun onResponse(call: Call<main_model>, response: Response<main_model>) {
                val data = response.body()
                if (data != null) {
                    newslist.addAll(data.articles)
                    val adapter = myAdapter(this@MainActivity, newslist)
                    recview.adapter = adapter

                } else {
                    Toast.makeText(this@MainActivity, "No data found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<main_model>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }


}