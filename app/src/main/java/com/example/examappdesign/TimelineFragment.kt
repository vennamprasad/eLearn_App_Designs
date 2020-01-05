package com.example.examappdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examappdesign.adapter.CategoryAdapter
import com.example.examappdesign.adapter.ClassInfoAdapter
import com.example.examappdesign.model.ClassInfo
import com.example.examappdesign.model.NewsResource
import com.example.examappdesign.retrofit.ApiClient
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.content_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class TimelineFragment : Fragment() {
    private var newsArrayList: ArrayList<ClassInfo> = ArrayList()
    private var mAdapter: ClassInfoAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.time_line_fragment, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        try {
            view.viewPager.adapter = CategoryAdapter(activity)
            view.viewPager.adapter = CategoryAdapter(activity)
            val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            view.recyclerView!!.layoutManager = mLayoutManager
            view.recyclerView!!.addItemDecoration(
                DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL)
            )
            loadJSON(view)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @SuppressLint("DefaultLocale")
    private fun loadJSON(view: View) {
        try {
            view.progressBar!!.visibility = View.VISIBLE
            if (checkConnection(context)) {
                val request = ApiClient.apiService
                val call: Call<NewsResource?>? = request.getTopHeadlines(
                    Locale.getDefault().country.toString().toLowerCase(),
                    API_KEY
                )
                call?.enqueue(object : Callback<NewsResource?> {
                    override fun onResponse(
                        call: Call<NewsResource?>?,
                        response: Response<NewsResource?>
                    ) {
                        if (response.isSuccessful && response.body()?.articles != null) {
                            if (!newsArrayList.isEmpty()) {
                                newsArrayList.clear()
                            }
                            view.progressBar!!.visibility = View.GONE
                            newsArrayList = response.body()!!.articles!!
                            mAdapter = ClassInfoAdapter(newsArrayList, context)
                            view.recyclerView!!.adapter = mAdapter
                        }
                    }

                    override fun onFailure(call: Call<NewsResource?>?, t: Throwable?) {
                        view.progressBar!!.visibility = View.GONE
                        show_msg(context, "Something went wrong...")
                    }
                })

            } else {
                view.progressBar!!.visibility = View.VISIBLE
                show_msg(context, "Internet connection not Available")
            }
        } catch (e: Exception) {
            view.progressBar!!.visibility = View.VISIBLE
            e.printStackTrace()
        }
    }
}
