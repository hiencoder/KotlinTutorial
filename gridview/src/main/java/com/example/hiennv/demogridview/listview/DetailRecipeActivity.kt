package com.example.hiennv.demogridview.listview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.*
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R

class DetailRecipeActivity : AppCompatActivity() {

    @BindView(R.id.wv_detail_recipe)
    lateinit var wvDetailRecipe: WebView
    lateinit var url: String
    lateinit var recipe: Recipe
    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)
        ButterKnife.bind(this)
        val intent = intent
        recipe = intent.getSerializableExtra("key_recipe") as Recipe
        url = recipe.detail

        wvDetailRecipe.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
            }

        }

        wvDetailRecipe.settings.javaScriptEnabled = true

        wvDetailRecipe.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

            }
        }
        wvDetailRecipe.loadUrl(url)
    }
}
