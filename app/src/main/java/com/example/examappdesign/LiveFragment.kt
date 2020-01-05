package com.example.examappdesign

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.MediaController
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examappdesign.adapter.CustomAdapter
import com.example.examappdesign.model.User
import kotlinx.android.synthetic.main.content_home.view.*
import kotlinx.android.synthetic.main.live_fragment.view.*
import java.util.*
import kotlin.collections.ArrayList


class LiveFragment : Fragment() {
    var arrayList: ArrayList<String> = ArrayList(
        Arrays.asList(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
        )
    )

    var index = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.live_fragment, container, false)
        loadvideo_content_view(view)
        return view
    }

    private fun loadvideo_content_view(view: View) {

        val mediacontroller = MediaController(context)
        mediacontroller.setAnchorView(view.video_content_view)
        view.video_content_view.setMediaController(mediacontroller)
        view.video_content_view.setVideoURI(Uri.parse(arrayList[index]))
        view.video_content_view.requestFocus()
        view.video_content_view.setOnCompletionListener { mp ->
            Toast.makeText(
                context,
                "Video over",
                Toast.LENGTH_SHORT
            ).show()
            if (index++ == arrayList.size) {
                index = 0
                mp.release()
                Toast.makeText(
                    context,
                    "Video over",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                view.video_content_view.setVideoURI(Uri.parse(arrayList[index]))
                view.video_content_view.start()
            }
        }
        //adding a layoutmanager
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity as Context?, LinearLayoutManager.VERTICAL, false)
        view.recyclerView_video_list!!.layoutManager = mLayoutManager
        view.recyclerView_video_list!!.addItemDecoration(
            DividerItemDecoration(activity, 0)
        )


        //crating an arraylist to store users using the data class user
        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"1", "Prasad vennam"))
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"2", "Mahesh Pande"))
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"3", "Durga Naveen"))
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"4", "Srikanth Basava"))
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"5", "Mamatha Boya"))
        users.add(User(context!!.getString(R.string.cultural_history_of_india)+"6", "Krupa Aditha"))
        //creating our adapter
        val adapter = CustomAdapter(users)

        //now adding the adapter to recyclerview
        view.recyclerView_video_list.adapter = adapter
    }

}
