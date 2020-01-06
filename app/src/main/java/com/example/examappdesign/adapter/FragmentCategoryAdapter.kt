package com.example.examappdesign.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.examappdesign.MainsFragment
import com.example.examappdesign.PrelimsFragment
import com.example.examappdesign.R


class FragmentCategoryAdapter(context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var mContext: Context = context;
    //fragments
    override fun getItem(position: Int): Fragment {
        val fragment: Fragment
        when (position) {
            0 -> fragment = PrelimsFragment()
            1 -> fragment = MainsFragment()
            else -> {
                fragment = MainsFragment()
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }

    //title
    override fun getPageTitle(position: Int): CharSequence? {
        var pageTitle: String? = null
        when (position) {
            0 -> pageTitle = mContext.getString(R.string.courses)
            1 -> pageTitle = mContext.getString(R.string.tests)
            else -> {
            }
        }
        return pageTitle

    }
}
