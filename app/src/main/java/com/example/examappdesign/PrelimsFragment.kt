package com.example.examappdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.EventDay
import com.example.examappdesign.adapter.FragmentCategoryAdapter
import kotlinx.android.synthetic.main.dashboard_layout.view.*

class PrelimsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vp_lay1, container, false)
        return view
    }
}
