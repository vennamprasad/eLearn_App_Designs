package com.example.examappdesign

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.EventDay
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
        val view: View = inflater.inflate(R.layout.dashboard_layout, container, false)
        val events: MutableList<EventDay> = ArrayList()
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 5)
        events.add(EventDay(calendar, R.drawable.sample_circle2))


        val calendar1 = Calendar.getInstance()
        calendar1.add(Calendar.DAY_OF_MONTH, 10)
        events.add(EventDay(calendar1, R.drawable.sample_circle))

        val calendar2 = Calendar.getInstance()
        calendar2.add(Calendar.DAY_OF_MONTH, 11)
        events.add(EventDay(calendar2, R.drawable.sample_circle2))

        val calendar3 = Calendar.getInstance()
        calendar3.add(Calendar.DAY_OF_MONTH, 13)
        events.add(EventDay(calendar3, R.drawable.sample_circle3))

        view.calendarView.setEvents(events)
        view.calendarView.setOnDayClickListener { eventDay: EventDay ->
            Toast.makeText(
                context,
                eventDay.calendar.time.toString() + " "
                        + eventDay.isEnabled,
                Toast.LENGTH_SHORT
            ).show()
        }
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
            context!!, childFragmentManager
        )
        view.tabs.setupWithViewPager(view.viewPager)
        return view
    }
}
