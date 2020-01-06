package com.example.examappdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_learning_analysis.*


class LearningAnalysisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_analysis)
        setBarChart()
    }

    private fun setBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(5f, 0))
        entries.add(BarEntry(7f, 1))
        entries.add(BarEntry(10f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(3f, 4))
        entries.add(BarEntry(3f, 5))

        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("G")
        labels.add("C")
        labels.add("W")
        labels.add("T")
        labels.add("S")
        labels.add("S")
        val data = BarData(labels, barDataSet)
        barChart.data = data // set the data and list of lables into chart

        barChart.setDescription("Performance Analysis")  // set the description

        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
        barDataSet.color = getColor(R.color.colorAccent)
        barChart.axisRight.setEnabled(false)
        barChart.axisLeft.setEnabled(false)
        val leftAxis: YAxis = barChart.getAxisLeft()
        leftAxis.isEnabled = false
        barChart.axisRight.setDrawLabels(false)
        barChart.axisLeft.setDrawLabels(false)
        barChart.xAxis.setDrawGridLines(false)
        barChart.legend.setEnabled(false)
        barChart.setPinchZoom(false)
        barChart.setDescription("")
        barChart.setTouchEnabled(false)
        barChart.setDoubleTapToZoomEnabled(false)
        barChart.xAxis.setEnabled(true)
        barChart.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        barChart.animateY(3000)
        barChart.invalidate()
    }
}
