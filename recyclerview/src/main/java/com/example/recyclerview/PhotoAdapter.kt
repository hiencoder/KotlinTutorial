package com.example.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide

class PhotoAdapter(val context: Context, val photoList: ArrayList<Photo>): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    //https://github.com/PhilJay/MPAndroidChart
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_photo,parent,false)
        return PhotoHolder(view,context)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo: Photo = photoList.get(position)
        holder.bindPhoto(photo)
    }

    class PhotoHolder(v: View, val context: Context): RecyclerView.ViewHolder(v){
        @BindView(R.id.iv_photo)
        lateinit var ivPhoto: ImageView
        @BindView(R.id.tv_date)
        lateinit var tvDate: TextView
        @BindView(R.id.tv_explanation)
        lateinit var tvExplanation: TextView
        init {
            ButterKnife.bind(this,v)
        }

        fun bindPhoto(photo: Photo){
            Glide.with(context).load(photo.url).into(ivPhoto)
            tvDate.text = photo.humanDate
            tvExplanation.text = photo.explanation
        }
    }
}