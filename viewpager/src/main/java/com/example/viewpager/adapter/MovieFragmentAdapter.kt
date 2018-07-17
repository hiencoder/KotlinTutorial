package com.example.viewpager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.viewpager.MovieFavorite
import com.example.viewpager.MovieFragment

class MovieFragmentAdapter(fm: FragmentManager, val movies: ArrayList<MovieFavorite>): FragmentPagerAdapter(fm) {
    //Gọi getItem khi chuẩn bị được hiển thị
    override fun getItem(position: Int): Fragment {
        return MovieFragment.newInstance(movies.get(position))
    }

    //Gọi getCount trước
    override fun getCount(): Int {
        return movies.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title: String = movies.get(position).title
        return title
    }
}