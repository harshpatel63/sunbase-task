package com.example.sunbase_task.ui.home

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sunbase_task.R
import com.example.sunbase_task.db.Converters
import com.example.sunbase_task.db.Image
import com.example.sunbase_task.network.properties.ImageObjectResponse
import retrofit2.Converter

class HomeLocalAdapter(private val context: Context, private val dataSet: ArrayList<Image>): BaseAdapter() {

    override fun getCount(): Int = dataSet.size

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView = ImageView(context)
        val converter = Converters()
        imageView.setImageResource(R.drawable.ic_baseline_search_24)
//        imageView.setImageBitmap(dataSet[p0].bitmapImage?.let { converter.toBitmap(it) })
        return imageView
    }

    fun updateArray(array: List<Image>) {
        dataSet.clear()
        dataSet.addAll(array)
        notifyDataSetChanged()
    }

}