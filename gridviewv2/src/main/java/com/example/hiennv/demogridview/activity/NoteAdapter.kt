package com.example.hiennv.demogridview.activity

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R

class NoteAdapter(val context: Context, val listNote: MutableList<Note>, val listener: OnNoteClickListener)
    : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    companion object {
        private val BACKGROUND_COLOR = hashMapOf(
                "0" to R.color.colorLowCarb,
                "1" to R.color.colorLowFat
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note,parent,false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note = listNote.get(position)
        holder.bindNoteData(note,context)
        holder.cvNote.setOnClickListener {
            listener.onClick(note)
        }
    }

    class NoteHolder(view: View) : RecyclerView.ViewHolder(view) {
        @BindView(R.id.cv_note)
        lateinit var cvNote: CardView
        @BindView(R.id.tv_note_title)
        lateinit var tvNoteTitle: TextView
        @BindView(R.id.tv_note_content)
        lateinit var tvNoteContent: TextView
        @BindView(R.id.tv_note_created_date)
        lateinit var tvNoteCreated: TextView

        init {
            ButterKnife.bind(this,view)
        }

        fun bindNoteData(note: Note,context: Context){
            tvNoteTitle.text = note.title
            val titleTypeface = ResourcesCompat.getFont(context,R.font.josefinsans_bold)
            tvNoteTitle.typeface = titleTypeface
            tvNoteTitle.setTextColor(ContextCompat.getColor(context, BACKGROUND_COLOR[(adapterPosition % 2).toString()] ?: R.color.colorPrimary))

            tvNoteContent.text = note.content
            val contentTypeface = ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
            tvNoteContent.typeface = contentTypeface

            tvNoteCreated.text = note.createdTime
            val createdTypeface = ResourcesCompat.getFont(context,R.font.quicksand_bold)
            tvNoteCreated.typeface = createdTypeface
        }
    }
}