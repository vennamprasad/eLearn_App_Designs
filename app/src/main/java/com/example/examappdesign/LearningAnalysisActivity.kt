package com.example.examappdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
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
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayShowTitleEnabled(true)
        actionBar.setTitle("Test Name")
        setBarChart()
    }

    private fun setBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(5f, 0))
        entries.add(BarEntry(7f, 1))
        entries.add(BarEntry(10f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(3f, 4))

        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("Guess")
        labels.add("Correct")
        labels.add("Wrong")
        labels.add("Total")
        labels.add("Skip")
        val data = BarData(labels, barDataSet)
        barChart.data = data // set the data and list of lables into chart
        barChart.alpha = 0.9f
        barChart.setDescriptionTypeface(
            ResourcesCompat.getFont(this, R.font.karla)
        )
        barChart.setDescription("Performance Analysis")  // set the description

        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
        barDataSet.color = getColor(R.color.colorAccent)
        barDataSet.valueTextSize = 15f;
        barChart.axisRight.isEnabled = false
        barChart.axisLeft.isEnabled = false
        val leftAxis: YAxis = barChart.axisLeft
        leftAxis.isEnabled = false
        barChart.axisRight.setDrawLabels(false)
        barChart.axisLeft.setDrawLabels(false)
        barChart.xAxis.setDrawGridLines(false)
        barChart.xAxis.textColor = resources.getColor(R.color.teal)
        barChart.xAxis.spaceBetweenLabels = 5
        barChart.legend.isEnabled = false
        barChart.setExtraOffsets(0f,0f,20f,12f);
        barChart.setPinchZoom(false)
        barChart.setDescription("")
        barChart.setTouchEnabled(false)
        barChart.isDoubleTapToZoomEnabled = false
        barChart.xAxis.isEnabled = true
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.animateY(3000)
        barChart.invalidate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    @SuppressLint("ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT)
                .show()
            R.id.action_notifications -> Toast.makeText(
                this,
                "Notifications selected",
                Toast.LENGTH_SHORT
            )
            android.R.id.home ->
                onBackPressed()
        }
        return true
    }

}
