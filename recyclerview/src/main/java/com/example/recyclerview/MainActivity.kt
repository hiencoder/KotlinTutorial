package com.example.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import butterknife.BindView

class MainActivity : AppCompatActivity(), ImageRequester.ImageRequestResponse {
    val TAG: String = MainActivity::class.java.simpleName
    @BindView(R.id.rv_photo)
    lateinit var rvPhoto: RecyclerView
    lateinit var photoAdapter: PhotoAdapter
    lateinit var photoList: ArrayList<Photo>
    var selecteLinear: Boolean = true

    override fun receivedNewPhoto(photo: Photo) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menu_change_layout -> selecteLinear = !selecteLinear
        }
        return super.onOptionsItemSelected(item)
    }
}
