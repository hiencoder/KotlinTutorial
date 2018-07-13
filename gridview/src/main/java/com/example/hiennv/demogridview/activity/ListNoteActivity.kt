package com.example.hiennv.demogridview.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.hiennv.demogridview.R
import java.text.SimpleDateFormat
import java.util.*

class ListNoteActivity : AppCompatActivity(), OnNoteClickListener{
    @BindView(R.id.rv_notes)
    lateinit var rvNote: RecyclerView

    @BindView(R.id.btn_add_note)
    lateinit var btnAddNote: FloatingActionButton

    lateinit var noteAdapter: NoteAdapter

    lateinit var listNote: MutableList<Note>

    override fun onClick(note: Note) {
        val intent = Intent(this,AddNoteActivity::class.java)
        intent.putExtra(Const.KEY_REQUEST_EDIT,note)
        startActivityForResult(intent,Const.REQUEST_EDIT)
    }

    //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_note)
        ButterKnife.bind(this)
        //getTimeCreated()
        listNote = Note.dummyData()
        noteAdapter = NoteAdapter(this,listNote,this)
        rvNote.adapter = noteAdapter
        rvNote.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
    }

    private fun getTimeCreated(): String{
        var result: String = ""
        val timeCurrent = System.currentTimeMillis()
        //convert time -> millisecond
        val date: Date = Date(timeCurrent)
        val sdf: SimpleDateFormat = SimpleDateFormat("E, MM-dd-yyyy HH:mm:ss a")
        sdf.timeZone = TimeZone.getTimeZone("GMT+7")
        result = sdf.format(date)
        Log.d("TimeZone",result)
        return result
    }

    @OnClick(R.id.btn_add_note)
    fun onClick(v: View){
        when(v.id){
            R.id.btn_add_note -> launchIntent();
        }
    }

    private fun launchIntent() {
        val intent = Intent(this,AddNoteActivity::class.java)
        startActivityForResult(intent,Const.REQUEST_ADD_NOTE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === Const.REQUEST_ADD_NOTE && resultCode === Activity.RESULT_OK){
            val note = data!!.getSerializableExtra(Const.KEY_ADD_NOTE)
            listNote.add(listNote.size, note as Note)
            noteAdapter = NoteAdapter(this,listNote,this)
            noteAdapter.notifyDataSetChanged()
        }
    }
}
