package com.example.sunbase_task.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunbase_task.R
import com.example.sunbase_task.network.properties.ImageObject
import com.example.sunbase_task.network.properties.ImageObjectResponse

class HomeAdapter(private val context: Context): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val dataSet = ImageObjectResponse()
    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.home_item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.main_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Log.i("afjalsf", "got it")
            Glide.with(holder.itemView).load(dataSet[position].urls.regular).into(holder.imageView)

    }

    override fun getItemCount(): Int = dataSet.size

    fun updateList(newData: ImageObjectResponse) {
        dataSet.clear()
        dataSet.addAll(newData)
        notifyDataSetChanged()
    }

}