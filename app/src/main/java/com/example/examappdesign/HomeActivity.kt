package com.example.examappdesign

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.time_line_fragment.*


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        //loading the default fragment
        //loading the default fragment
        loadFragment(TimelineFragment())
        bottom_navigation!!.selectedItemId = R.id.navigation_timeline;
        bottom_navigation!!.setOnNavigationItemSelectedListener(this)

    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_search -> Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT)
                .show()
            R.id.action_notifications -> Toast.makeText(
                this,
                "Notifactions selected",
                Toast.LENGTH_SHORT
            )
            android.R.id.home ->
                loadFragment(TimelineFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_prelims -> fragment = PrelimsFragment()
            R.id.navigation_mains -> fragment = MainsFragment()
            R.id.navigation_timeline -> fragment = TimelineFragment()
            R.id.navigation_dashboard -> fragment = DashboardFragment()
            R.id.navigation_live -> fragment = LiveFragment()
        }

        return loadFragment(fragment)
    }
}
