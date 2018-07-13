package com.example.hiennv.demogridview.gridview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R

class MainActivity : AppCompatActivity() {
    @BindView(R.id.gv_book)
    lateinit var gvBook: GridView
    lateinit var bookAdapter: BookAdapter
    val listBook: ArrayList<Book> = dummyBook()

    private fun dummyBook(): ArrayList<Book> {
        var books: ArrayList<Book> = mutableListOf<Book>() as ArrayList<Book>
        books.add(Book("ABC: An Amazing Alphabet Book!", "http://www.raywenderlich.com/wp-content/uploads/2016/03/abc.jpg", "Dr. Seuss", R.drawable.abc))
        books.add(Book("Are You My Mother?", "http://www.raywenderlich.com/wp-content/uploads/2016/03/areyoumymother.jpg", "Karen Katz", R.drawable.areyoumymother))
        books.add(Book("Where is Baby\\'s Belly Button", "http://www.raywenderlich.com/wp-content/uploads/2016/03/whereisbabysbellybutton.jpg", "Dr. Seuss", R.drawable.whereisbabysbellybutton))
        books.add(Book("On The Night You Were Born", "http://www.raywenderlich.com/wp-content/uploads/2016/03/onthenightyouwereborn.jpg", "Nancy Tillman", R.drawable.onthenightyouwereborn))
        books.add(Book("Hand Hand Fingers Thumb", "http://www.raywenderlich.com/wp-content/uploads/2016/03/handhandfingersthumb.jpg", "Dr. Seuss", R.drawable.handhandfingersthumb))
        books.add(Book("The Very Hungry Caterpillar", "http://www.raywenderlich.com/wp-content/uploads/2016/03/theveryhungrycaterpillar.jpg", "", R.drawable.theveryhungrycaterpillar))
        books.add(Book("The Going To-Bed Book", "http://www.raywenderlich.com/wp-content/uploads/2016/03/thegoingtobedbook.jpg", "Eric Carle", R.drawable.thegoingtobedbook))
        books.add(Book("Oh Baby Go Baby", "http://www.raywenderlich.com/wp-content/uploads/2016/03/ohbabygobaby.jpg", "Dr. Seuss", R.drawable.ohbabygobaby))
        books.add(Book("The Tooth Book", "http://www.raywenderlich.com/wp-content/uploads/2016/03/thetoothbook.jpg", "Sandra Boynton", R.drawable.thetoothbook))
        books.add(Book("One Fish, Two Fish, Red Fish, Blue Fish", "http://www.raywenderlich.com/wp-content/uploads/2016/03/onefish.jpg", "Eric Carle", R.drawable.onefish))

        return books
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        bookAdapter = BookAdapter(this, listBook)
        gvBook.adapter = bookAdapter
        Log.d("Booksize",listBook.size.toString())
        gvBook.setOnItemClickListener { adapterView, view, position, l -> launcheIntent(listBook.get(position)) }
    }

    private fun launcheIntent(book: Book) {
        var intent: Intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("book_detail",book)
        startActivity(intent)
    }

}
