package com.example.examappdesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.examappdesign.model.ModelObject


class CategoryAdapter(context: Context?) : PagerAdapter() {
    private var mContext = context;

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject: ModelObject = ModelObject.values().get(position)
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }

    override fun getCount(): Int {
        return ModelObject.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum: ModelObject = ModelObject.values().get(position)
        return customPagerEnum.titleResId
    }
}
