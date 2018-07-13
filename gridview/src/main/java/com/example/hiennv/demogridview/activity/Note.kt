package com.example.hiennv.demogridview.activity

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Note(val title: String, val content: String, val createdTime: String) : Serializable{
    //Non use constructor -> use second constructor
/*
    private var mTitle: String = ""
    public var Title: String
        get() {
            return mTitle
        }
        set(value) {mTitle = value}

    private var mContent: String = ""
    private var mCreatedTime: String = ""
*/
    companion object {
        fun dummyData(): MutableList<Note>{
            var listNote: MutableList<Note> = mutableListOf<Note>()
            listNote.add(Note("Note 1","Content 1", getTimeCreated()))
            listNote.add(Note("Note 2","Content 2", getTimeCreated()))
            listNote.add(Note("Note 3","Content 3", getTimeCreated()))
            listNote.add(Note("Note 4","Content 4", getTimeCreated()))
            listNote.add(Note("Note 5","Content 5", getTimeCreated()))
            return listNote
        }

        public fun getTimeCreated(): String{
            var result: String ?= null
            val timeCurrent = System.currentTimeMillis()
            //convert time -> millisecond
            val date: Date = Date(timeCurrent)
            val sdf: SimpleDateFormat = SimpleDateFormat("E, MM-dd-yyyy HH:mm:ss a")
            sdf.timeZone = TimeZone.getTimeZone("GMT+7")
            result = sdf.format(date)
            return result.toString()
        }
    }
}