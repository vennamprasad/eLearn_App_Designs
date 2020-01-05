package com.example.examappdesign

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/* URLS*/
const val BASE_URL = "https://newsapi.org/v2/"

//API Key
const val API_KEY = "15b744f890084f54b6f1141cf2e12e84"


//connections
fun checkConnection(context: Context?): Boolean {
    return (context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null
}

fun show_msg(context: Context?, message: String) {
    Toast.makeText(context, "Internet connection not Available", Toast.LENGTH_SHORT).show()
}
