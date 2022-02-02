package com.example.sunbase_task.ui.search

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sunbase_task.network.properties.Result

class SearchAdapter(private val context: Context, private val dataSet: ArrayList<Result>): BaseAdapter() {

    override fun getCount(): Int = dataSet.size

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView: ImageView = ImageView(context)
        Glide.with(context).load(dataSet[p0].urls.regular).into(imageView)
        return imageView
    }

    fun updateArray(array: ArrayList<Result>) {
        dataSet.clear()
        dataSet.addAll(array)
        notifyDataSetChanged()
    }

}