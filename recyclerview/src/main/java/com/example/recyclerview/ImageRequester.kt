package com.example.recyclerview

import android.content.Context
import android.net.Uri
import com.bumptech.glide.Glide.init
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ImageRequester(activity: MainActivity) {
    interface ImageRequestResponse{
        fun receivedNewPhoto(photo: Photo)
    }

    val calendar: Calendar = Calendar.getInstance()
    val sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    val responseListener: ImageRequestResponse
    val context: Context
    val okHttpClient: OkHttpClient
    var isLoading: Boolean = false

    init {
        responseListener = activity
        context = activity
        okHttpClient = OkHttpClient()
    }

    fun getPhoto(){
        val date = sdf.format(calendar.time)

        //Create url
        val urlRequest = Uri.Builder().scheme(Const.URL_SCHEME)
                .appendPath(Const.URL_AUTHORITY)
                .appendPath(Const.URL_PATH_1)
                .appendPath(Const.URL_PATH_2)
                .appendQueryParameter(Const.URL_QUERY_PARAM_DATE, date)
                .appendQueryParameter(Const.URL_QUERY_PARAM_API_KEY,context.getString(R.string.api_key))
                .build().toString()

        val request = Request.Builder().url(urlRequest).build()
        isLoading = true

        okHttpClient.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                isLoading = false
                e!!.printStackTrace()
            }

            override fun onResponse(call: Call?, response: Response?) {
                val photoJson = JSONObject(response!!.body()!!.string())
                //set date
                calendar.add(Calendar.DAY_OF_YEAR,-1)

                if (photoJson.getString(Const.MEDIA_TYPE_KEY) != Const.MEDIA_TYPE_VIDEO_VALUE){
                    val receiPhoto = Photo(photoJson)
                    responseListener.receivedNewPhoto(receiPhoto) //Display new photo
                    isLoading = false
                }else{
                    getPhoto()
                }
            }

        })
    }
}