package com.example.viewpager

import android.content.Context
import android.util.Log

object Const {
    val KEY_TITLE = "title"
    val KEY_RATING = "rating"
    val KEY_POSTER_URI = "poster_uri"
    val KEY_OVERVIEW = "overview"

    fun identifieImage(context: Context, posterUri: String): Int{
        val idImage = context.resources.getIdentifier(posterUri,"drawable",context.packageName)
        return idImage
    }

    fun d(tag: String, message: String){
        Log.d(tag,message)
    }

    fun e(tag: String, message: String){
        Log.e(tag, message)
    }

    fun i(tag: String, message: String){
        Log.i(tag,message)
    }
}