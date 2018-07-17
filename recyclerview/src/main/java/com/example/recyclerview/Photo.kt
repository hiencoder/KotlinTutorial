package com.example.recyclerview

import org.json.JSONObject
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Photo(jsonPhoto: JSONObject): Serializable{
    private lateinit var photoDate: String
    lateinit var humanDate: String
        private set

    private lateinit var explanation: String
        private set

    private lateinit var url: String
        private set

    init {
        photoDate = jsonPhoto.getString(Const.DATE)
        humanDate = convertToHumanDate(photoDate)
        explanation = jsonPhoto.getString(Const.EXPLANATION)
        url = jsonPhoto.getString(Const.URL)
    }

    /**
     *
     */
    private fun convertToHumanDate(photoDate: String?): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val humanDateFormat = SimpleDateFormat("dd MM yyyy")

        val parsedDateFormat = dateFormat.parse(photoDate)
        val calendar = Calendar.getInstance()

        //Set date for calendar
        calendar.time = parsedDateFormat

        return humanDate.format(calendar.time)

    }


}