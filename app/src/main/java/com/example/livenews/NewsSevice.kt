package com.example.livenews

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//"https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ac553136a2cc4745a33536f521a325aa"

const val base_url="https://newsapi.org/"
    const val api_key="ac553136a2cc4745a33536f521a325aa"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$api_key")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>

}
    // sigleton object
    object NewsService{
        val newsinterface:NewsInterface
        init {
            val retrofit=Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsinterface=retrofit.create(NewsInterface::class.java)

    }
}
