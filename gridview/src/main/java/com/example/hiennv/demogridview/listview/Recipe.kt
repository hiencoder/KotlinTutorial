package com.example.hiennv.demogridview.listview

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.io.Serializable

class Recipe(val titlte: String,
             val description: String,
             val detail: String,
             val imageUrl: String,
             val label: String) : Serializable{

    companion object {
        //Function parse json -> List<Recipe>
        public fun parseJsonFromAsset(filename: String, context: Context): ArrayList<Recipe> {
            val recipeList = ArrayList<Recipe>()
            try {
                val jsonString = loadJsonFromAsset(filename, context)
                val jsonObject = JSONObject(jsonString)
                val jsonArray = jsonObject.getJSONArray("recipes")
                for (i in 0..jsonArray.length()) {
                    val obj: JSONObject = jsonArray.getJSONObject(i)
                    val title = obj.getString("title")
                    val image = obj.getString("image")
                    val description = obj.getString("description")
                    val label = obj.getString("dietLabel")
                    val detail = obj.getString("url")

                    val recipe = Recipe(title,description,detail,image,label)

                    recipeList.add(recipe)
                }
            } catch (ex: JSONException) {
                ex.printStackTrace()
            }
            return recipeList
        }


        private fun loadJsonFromAsset(filename: String, context: Context): String {
            var jsonResult = ""
            try {
                val inputStream: InputStream = context.assets.open(filename)
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                jsonResult = String(buffer, Charsets.UTF_8)
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
            return jsonResult
        }
    }
}