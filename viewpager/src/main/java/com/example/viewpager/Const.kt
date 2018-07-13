package com.example.viewpager

import android.content.Context

object Const {
    val KEY_TITLE = "title"
    val KEY_RATING = "rating"
    val KEY_POSTER_URI = "poster_uri"
    val KEY_OVERVIEW = "overview"

    fun identifieImage(context: Context, posterUri: String): Int{
        val idImage = context.resources.getIdentifier(posterUri,"drawable",context.packageName)
        return idImage
    }
}