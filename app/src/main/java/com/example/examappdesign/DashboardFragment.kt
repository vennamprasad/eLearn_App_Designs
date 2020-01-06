package com.example.examappdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.examappdesign.adapter.FragmentCategoryAdapter
import kotlinx.android.synthetic.main.dashboard_layout.view.*
import java.util.*
import kotlin.collections.ArrayList


class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard_layout, container, false)
        view.calendarView.setOnDayClickListener { eventDay: EventDay ->
        Toast.makeText(
            context,
            eventDay.calendar.time.toString() + " "
                    + eventDay.isEnabled,
            Toast.LENGTH_SHORT
        ).show()
    }
        val getDateButton =
            view.getDateButton.setOnClickListener { v: View? ->
            for (calendar in view.calendarView.selectedDates) {
                println(calendar.time.toString())
                Toast.makeText(
                    context,
                    calendar.time.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        view.viewPager.adapter = FragmentCategoryAdapter(
            context!!,childFragmentManager
        )
        view.tabs.setupWithViewPager(view.viewPager)
        return view
    }
}
