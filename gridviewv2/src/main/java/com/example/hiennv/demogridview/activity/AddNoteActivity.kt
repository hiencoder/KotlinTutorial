package com.example.hiennv.demogridview.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.hiennv.demogridview.R

class AddNoteActivity : AppCompatActivity() {
    @BindView(R.id.et_title)
    lateinit var etTitle: EditText

    @BindView(R.id.et_content)
    lateinit var etContent: EditText

    @BindView(R.id.btn_save_note)
    lateinit var btnSaveNote: Button

    var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        ButterKnife.bind(this)
        val intent = intent
        note = intent.getSerializableExtra(Const.KEY_REQUEST_EDIT) as Note?

        if (note != null) {
            Log.d("NoteEdit", note!!.title)
        }
    }

    @OnClick(R.id.btn_save_note)
    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_save_note -> handleAddNote()
        }
    }

    private fun handleAddNote() {
        val title = etTitle.text.toString()
        val content = etContent.text.toString()

        if (title != null && !title.equals("") &&
                content != null && !content.equals("")) {
            val intent = Intent()
            intent.putExtra(Const.KEY_ADD_NOTE, Note(title, content, Note.getTimeCreated()))
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            if (title == null || title.equals("")) {
                etTitle.error = "Title empty!"
            }
            if (content == null || content.equals("")) {
                etContent.error = "Content empty!"
            }
        }
    }

}
