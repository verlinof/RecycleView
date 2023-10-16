package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val newsList: ArrayList<News>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.newsImage.setImageResource(currentItem.newsImage)
        holder.tvHeading.text = currentItem.heading
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)

    }


}