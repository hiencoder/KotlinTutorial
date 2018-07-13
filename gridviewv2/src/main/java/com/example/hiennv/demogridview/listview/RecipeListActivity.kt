package com.example.hiennv.demogridview.listview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R

class RecipeListActivity : AppCompatActivity() {
    @BindView(R.id.lv_recipe)
    lateinit var lvRecipe: ListView
    lateinit var recipeAdapter: RecipeAdapter
    lateinit var listRecipe: ArrayList<Recipe>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        ButterKnife.bind(this)

        listRecipe = Recipe.parseJsonFromAsset("recipes.json",this)
        recipeAdapter = RecipeAdapter(this,listRecipe)
        lvRecipe.adapter = recipeAdapter

        lvRecipe.setOnItemClickListener { adapterView, view, position, l ->  launchIntent(position)}
    }

    private fun launchIntent(position: Int) {
        val intent = Intent(this,DetailRecipeActivity::class.java)
        intent.putExtra("key_recipe",listRecipe.get(position))
        startActivity(intent)
    }
}
