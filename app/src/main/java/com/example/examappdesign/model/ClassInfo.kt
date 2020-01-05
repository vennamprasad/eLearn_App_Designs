package com.example.examappdesign.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class ClassInfo {
    @SerializedName("source")
    @Expose
    val source: Source? = null
    @SerializedName("author")
    @Expose
    val author: String = ""
    @SerializedName("title")
    @Expose
    val title: String = ""
    @SerializedName("description")
    @Expose
    val description: String = ""
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String = ""
    @SerializedName("publishedAt")
    @Expose
    val publishedAt: Date? = null
    @SerializedName("content")
    @Expose
    val content: String = ""

}
