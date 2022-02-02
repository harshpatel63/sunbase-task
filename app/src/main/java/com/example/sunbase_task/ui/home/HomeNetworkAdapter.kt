package com.example.sunbase_task.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunbase_task.R
import com.example.sunbase_task.network.properties.ImageObject
import com.example.sunbase_task.network.properties.ImageObjectResponse

class HomeNetworkAdapter(private val context: Context, private val dataSet: ImageObjectResponse): BaseAdapter() {

    override fun getCount(): Int = dataSet.size

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView: ImageView = ImageView(context)
        Glide.with(context).load(dataSet.get(p0).urls.regular).into(imageView)
        return imageView
    }

    fun updateArray(array: ImageObjectResponse) {
        dataSet.clear()
        dataSet.addAll(array)
        notifyDataSetChanged()
    }

}