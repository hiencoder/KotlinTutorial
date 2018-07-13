package com.example.hiennv.demogridview.recyclerview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.hiennv.demogridview.R
import com.example.hiennv.demogridview.listview.Recipe
import com.squareup.picasso.Picasso

class RecipeAdapter(val context: Context, val listRecipe: ArrayList<Recipe>) :
        RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    companion object {
        /*Hashmap color*/
        private val LABEL_COLORS = hashMapOf(
                "Low-Carb" to R.color.colorLowCarb,
                "Low-Fat" to R.color.colorLowFat,
                "Low-Sodium" to R.color.colorLowSodium,
                "Medium-Carb" to R.color.colorMediumCarb,
                "Vegetarian" to R.color.colorVegetarian,
                "Balanced" to R.color.colorBalanced
        )

    }
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecipeHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false)
        return RecipeHolder(view)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        val recipe = listRecipe.get(position)
        holder.bindData(recipe,context)
    }

    class RecipeHolder(val view: View) : RecyclerView.ViewHolder(view) {
        @BindView(R.id.iv_recipe)
        lateinit var ivRecipe: ImageView

        @BindView(R.id.tv_title)
        lateinit var tvTitle: TextView

        @BindView(R.id.tv_description)
        lateinit var tvDescription: TextView

        @BindView(R.id.tv_label)
        lateinit var tvLabel: TextView

        init {
            ButterKnife.bind(this,view)
        }

        fun bindData(recipe: Recipe, context: Context){
            Picasso.with(context).load(recipe.imageUrl).placeholder(R.drawable.abc).into(ivRecipe)
            tvTitle.text = recipe.titlte
            val titleTypeface = ResourcesCompat.getFont(context,R.font.josefinsans_bold)
            tvTitle.typeface = titleTypeface

            tvDescription.text = recipe.description
            val descriptionTypeface = ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
            tvDescription.typeface = descriptionTypeface

            tvLabel.text = recipe.label
            val labelTypeface = ResourcesCompat.getFont(context,R.font.quicksand_bold)
            tvLabel.typeface = labelTypeface
            tvLabel.setTextColor(ContextCompat.getColor(context, LABEL_COLORS[recipe.label] ?: R.color.colorPrimary))
        }
    }
}