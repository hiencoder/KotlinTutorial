package com.example.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife

class PhotoAdapter(val context: Context, val photoList: ArrayList<Photo>): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, po: Int): PhotoHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(p0: PhotoHolder, p1: Int) {

    }

    class PhotoHolder(v: View): RecyclerView.ViewHolder(v){
        @BindView(R.id.iv_photo)
        lateinit var ivPhoto: ImageView
        init {
            ButterKnife.bind(this,v)
        }

        fun bindPhoto(photo: Photo){

        }
    }
}