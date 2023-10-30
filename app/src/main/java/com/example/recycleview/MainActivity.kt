package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var newsBody: Array<String>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.greyhound,
            R.drawable.granturismo,
            R.drawable.maze_runner,
            R.drawable.onepiece,
        )

        newsBody = arrayOf(
            getString(R.string.news_greyhound),
            getString(R.string.news_gran_turismo),
            getString(R.string.news_maze_runner),
            getString(R.string.news_one_piece),
        )

        heading = arrayOf(
            "GreyHound film perang",
            "GranTurismo Film balap",
            "MazeRunner film Action adventure",
            "One Piece film anime paling banyak episodenya",
        )

        newRecyclerView = findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserData()

    }

    private fun getUserData() {
        for (i in imageId.indices){
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, NewsActivity::class.java)
                intent.putExtra("newsHeading", newArrayList[position].heading)
                intent.putExtra("newsImage", newArrayList[position].newsImage)
                intent.putExtra("newsBody", newsBody[position])
                startActivity(intent)

            }

        })
    }
}