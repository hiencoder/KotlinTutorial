package com.example.hiennv.demogridview.gridview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.hiennv.demogridview.R

class BookAdapter(private val context: Context, private val listBook: ArrayList<Book>) : BaseAdapter() {
    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
        var view: View = inflater.inflate(R.layout.item_book_case,parent,false)
        var ivBook: ImageView = view.findViewById(R.id.iv_book)
        var tvBookName: TextView = view.findViewById(R.id.tv_book_name)
        var tvBookAuthor: TextView = view.findViewById(R.id.tv_book_author)

        var book: Book = getItem(position)
        Log.d("BookName",book.name)
/*
        if (book.image != null && !book.image.equals(""))
            Picasso.with(context).load(book.image).into(ivBook)
        else
*/
            ivBook.setImageResource(book.replace)
        tvBookName.text = book.name
        tvBookAuthor.text = book.author

        return view
    }

    override fun getItem(position: Int): Book {
        return listBook.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listBook.size
    }

    class ViewHolder {
        var ivBook: ImageView? = null
        var tvBookName: TextView? = null
        var tvBookAuthor: TextView? = null
        var rbLike: RatingBar? = null
    }
}