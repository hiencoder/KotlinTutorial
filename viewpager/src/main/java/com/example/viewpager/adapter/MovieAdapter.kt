package com.example.viewpager.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.viewpager.MovieFavorite
import com.example.viewpager.R

class MovieAdapter(val context: Context, val listMovie: ArrayList<MovieFavorite>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object`)
    }

    //return size
    override fun getCount(): Int {
        return listMovie.size
    }

    //remove tiem
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    //inflate item view bind data
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie,container,false)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvRating: TextView = view.findViewById(R.id.tv_rating)
        val tvOverView: TextView = view.findViewById(R.id.tv_overview)
        val ivMovie: ImageView = view.findViewById(R.id.iv_movie)

        //Bind data movie
        val movieFavorite = listMovie.get(position)
        Log.d("Title",movieFavorite.title)
        val imageUri: Int = context.resources.getIdentifier(movieFavorite.postUri,"drawable",context.packageName)
        tvTitle.text = movieFavorite.title
        tvRating.text = movieFavorite.rating.toString() + "/" + "10"
        tvOverView.text = movieFavorite.overview
        Glide.with(context).load(imageUri).into(ivMovie)

        container.addView(view)
        return view
    }
}