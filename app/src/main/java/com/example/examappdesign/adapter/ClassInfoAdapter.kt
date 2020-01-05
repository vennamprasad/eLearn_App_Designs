package com.example.examappdesign.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.examappdesign.R
import com.example.examappdesign.model.ClassInfo
import com.squareup.picasso.Picasso
import java.util.*


class ClassInfoAdapter(

    private val newsList: ArrayList<ClassInfo>,
    param: Context?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    val context: Context? = param
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val menuItemLayoutView: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.class_item, viewGroup, false)
        return NewsWithImageViewHolder(menuItemLayoutView)

    }


    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(@NonNull viewHolder: RecyclerView.ViewHolder, position: Int) {
        try {
            loadNewsFeed(viewHolder, position)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun loadNewsFeed(viewHolder: RecyclerView.ViewHolder, position: Int) {
        try {
            val menuItemHolder: NewsWithImageViewHolder = viewHolder as NewsWithImageViewHolder
//            val topic: ClassInfo = newsList[position]
            menuItemHolder.title.text =
                context?.getString(R.string.cultural_history_of_india) + position
            menuItemHolder.description.text =
                context?.getString(R.string.prasad_vennam_master_of_commerce) + position
            Picasso.get()
                .load("https://www.triptoindia.com/blog/wp-content/uploads/2012/02/slider-6-1024x463.jpg")
                .placeholder(R.drawable.edu)
                .resize(400, 200)
                .centerInside()
                .into(menuItemHolder.ivNews)
        } catch (exc: Exception) {
            exc.printStackTrace()
        }
    }

    inner class NewsWithImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)
        var ivNews: ImageView = itemView.findViewById(R.id.urlToImage)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}