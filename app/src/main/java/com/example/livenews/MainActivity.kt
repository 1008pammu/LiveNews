package com.example.livenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NewsItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.news_recycler)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val newslist:MutableList<String> = mutableListOf()
        for (i in 0 until  100){
          newslist.add("item $i")

        }
        val adapter=NewsAdapter(newslist,this)
        recyclerView.adapter=adapter
    getnews()

    }
    private fun getnews(){
        val news=NewsService.newsinterface.getHeadlines("in",1)
        news.enqueue(object:Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
               val news=response.body()
                if (news!=null){
                    Log.d("pramod",news.toString())
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
           Log.d("pramod","Error in Feching News",t)
            }
        })


    }}

