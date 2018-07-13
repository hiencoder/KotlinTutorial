package com.example.viewpager

import android.content.Context
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MovieFavorite(val rating: Int,
                    val title: String,
                    val postUri: String,
                    val overview: String) {
    companion object {
        public fun parseJsonFromAsset(context: Context, fileName: String):ArrayList<MovieFavorite>{
            var listMovie = ArrayList<MovieFavorite>()
            try {
                val jsonFavoriteResult = JSONObject(loadJsonFromAsset(context,fileName))
                val arrayFavorite = jsonFavoriteResult.getJSONArray("movies")
                for (index in 0..arrayFavorite.length()){
                    val jsonFavorite: JSONObject = arrayFavorite.getJSONObject(index)
                    val rating = jsonFavorite.getInt("rating")
                    val title = jsonFavorite.getString("title")
                    val postUri = jsonFavorite.getString("posterUri")
                    val overview = jsonFavorite.getString("overview")

                    val favorite = MovieFavorite(rating, title, postUri, overview)

                    listMovie.add(favorite)
                }
            }catch (ex: JSONException){
                ex.printStackTrace()
            }
            return listMovie
        }

        public fun loadJsonFromAsset(context: Context, fileName: String): String{
            var result: String = ""
            try {
                val inputStream = context.assets.open(fileName)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                result = String(buffer,Charsets.UTF_8)

                Log.d("JsonResult",result)
            }catch (ex: IOException){
                ex.printStackTrace()
            }
            return result
        }
    }
}