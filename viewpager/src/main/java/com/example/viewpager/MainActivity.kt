package com.example.viewpager

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.example.viewpager.adapter.MovieAdapter
import com.example.viewpager.adapter.MovieFragmentAdapter

class MainActivity : AppCompatActivity() {
    @BindView(R.id.vp_favorite)
    lateinit var vpFavorite: ViewPager
    lateinit var movieAdapter: MovieAdapter

    lateinit var movieFragmentAdapter: MovieFragmentAdapter

    val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
/*
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
*/
        movieFragmentAdapter = MovieFragmentAdapter(supportFragmentManager,MovieFavorite.parseJsonFromAsset(this,"movies.json"))
        vpFavorite.adapter = movieFragmentAdapter
        vpFavorite.currentItem = 0
        vpFavorite.offscreenPageLimit = 8
        vpFavorite.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
            override fun onAdapterChanged(p0: ViewPager, p1: PagerAdapter?, p2: PagerAdapter?) {

            }

            override fun onPageScrollStateChanged(position: Int) {
                Const.d(TAG,"onPageScrollStateChanged: " + position)
            }

            override fun onPageSelected(position: Int) {
                Const.d(TAG,"onPageSelected: " + position)
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                Const.d(TAG,"onPageScrolled: " + p0 + "\n" + p1 + "\n: " + p2)
            }
        })
    }
}
