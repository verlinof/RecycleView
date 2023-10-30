package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsHeading: TextView = findViewById(R.id.tvHeading)
        val newsImage: ImageView = findViewById(R.id.ivNewsImage)
        val newsBody: TextView = findViewById(R.id.tvNewsBody)

        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("newsHeading")
        val imageId = bundle!!.getInt("newsImage")
        val body = bundle!!.getString("newsBody")

        newsHeading.text = heading
        newsImage.setImageResource(imageId)
        newsBody.text = body
    }
}