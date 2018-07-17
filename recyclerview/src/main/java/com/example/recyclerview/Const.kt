package com.example.recyclerview

object Const {
    val API_URL: String = "https://api.nasa.gov/planetary/apod?api_key=OihgQAdy2PpAmLZJfobqa3rWkLFNGoB472O8IVyh"

    //Key for JSONObject
    val DATE = "date"
    val EXPLANATION = "explanation"
    val URL = "url"

    //KEY API PARAM
    val URL_SCHEME = "https"
    val MEDIA_TYPE_KEY = "media_type"
    val MEDIA_TYPE_VIDEO_VALUE = "video"
    val URL_AUTHORITY = "api.nasa.gov"
    val URL_PATH_1 = "planetary"
    val URL_PATH_2 = "apod"
    val URL_QUERY_PARAM_DATE = "date"
    val URL_QUERY_PARAM_API_KEY = "api_key"
}