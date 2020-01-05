package com.example.examappdesign.retrofit
import com.example.examappdesign.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    /**
     * Get Retrofit Instance
     */
    private val retrofitInstance: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /**
     * Get API Service
     *
     * @return API Service
     */
    val apiService: ApiResponse
        get() = retrofitInstance.create(ApiResponse::class.java)
}