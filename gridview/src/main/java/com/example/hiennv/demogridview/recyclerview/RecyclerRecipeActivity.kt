package com.example.hiennv.demogridview.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R
import com.example.hiennv.demogridview.listview.Recipe

class RecyclerRecipeActivity : AppCompatActivity() {
    @BindView(R.id.rv_recipe)
    lateinit var rvRecipe: RecyclerView
    lateinit var listRecipe: ArrayList<Recipe>
    lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_recipe)
        ButterKnife.bind(this)
        listRecipe = Recipe.parseJsonFromAsset("recipes.json",this)
        recipeAdapter = RecipeAdapter(this,listRecipe)
        rvRecipe.adapter = recipeAdapter
        rvRecipe.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        rvRecipe.itemAnimator = DefaultItemAnimator()
    }
}
