package com.example.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.example.viewpager.adapter.MovieAdapter

class MainActivity : AppCompatActivity() {
    @BindView(R.id.vp_favorite)
    lateinit var vpFavorite: ViewPager
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        movieAdapter = MovieAdapter(this,MovieFavorite.parseJsonFromAsset(this,"movies.json"))
        Log.d("MovieSize",MovieFavorite.parseJsonFromAsset(this,"movies.json").size.toString())
        vpFavorite.adapter = movieAdapter
        vpFavorite.currentItem = 0
        vpFavorite.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {

            }
        })
    }
}
