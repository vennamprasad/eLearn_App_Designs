package com.example.examappdesign.retrofit
import com.example.examappdesign.model.NewsResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiResponse {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResource?>?

    @GET("top-headlines")
    fun getWorldHeadlines(
        @Query("sources") sources: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResource?>?

    @GET("top-headlines")
    fun getCategoryOfHeadlines(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResource?>?


}