package com.example.hiennv.demogridview.listview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hiennv.demogridview.R
import com.squareup.picasso.Picasso

class RecipeAdapter(val context: Context, val listRecipe: ArrayList<Recipe>): BaseAdapter() {
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /*Use color*/
    companion object {
        private val LABEL_COLORS = hashMapOf(
                "Low-Carb" to R.color.colorLowCarb,
                "Low-Fat" to R.color.colorLowFat,
                "Low-Sodium" to R.color.colorLowSodium,
                "Medium-Carb" to R.color.colorMediumCarb,
                "Vegetarian" to R.color.colorVegetarian,
                "Balanced" to R.color.colorBalanced
        )
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Using ViewHolder
        val view: View
        val viewHolder: ViewHolder
        //1.
        if (convertView == null){
            //2. Inflate view
            view = inflater.inflate(R.layout.item_recipe,parent,false)

            //3. FindView
            viewHolder = ViewHolder()
            viewHolder.ivRecipe = view.findViewById(R.id.iv_recipe)
            viewHolder.tvTitle = view.findViewById(R.id.tv_title)
            viewHolder.tvDescription = view.findViewById(R.id.tv_description)
            viewHolder.tvLabel = view.findViewById(R.id.tv_label)

            //.4 Set tag for view
            view.tag = viewHolder
        }else{
            //5. get tag
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        //6. Bind data
        val recipe = getItem(position)
        Picasso.with(context).load(recipe.imageUrl).placeholder(R.drawable.abc).into(viewHolder.ivRecipe)
        viewHolder.tvTitle.text = recipe.titlte
        viewHolder.tvDescription.text = recipe.description
        viewHolder.tvLabel.text = recipe.label
        //SettextColor for label
        viewHolder.tvLabel.setTextColor(ContextCompat.getColor(context, LABEL_COLORS[recipe.label] ?: R.color.colorPrimary))

        //Set font
        val titleTypeFace = ResourcesCompat.getFont(context,R.font.josefinsans_bold)
        viewHolder.tvTitle.typeface = titleTypeFace

        val descriptionTypeFace = ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
        viewHolder.tvDescription.typeface = descriptionTypeFace

        val labelTypeFace = ResourcesCompat.getFont(context,R.font.quicksand_bold)
        viewHolder.tvLabel.typeface = labelTypeFace
/*
        val view = inflater.inflate(R.layout.item_recipe,parent,false)
        val ivRecipe: ImageView = view.findViewById(R.id.iv_recipe)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
        val tvLabel: TextView = view.findViewById(R.id.tv_label)

        val recipe = getItem(position)
        Log.d("ImageUrl",recipe.imageUrl)
        //Picasso.with(context).load(recipe.imageUrl).into(ivRecipe)
        Glide.with(context).load(recipe.imageUrl).into(ivRecipe)
        tvTitle.text = recipe.titlte
        tvLabel.text = recipe.label
        tvDescription.text = recipe.description

        return view
*/
        return view
    }

    override fun getItem(position: Int): Recipe {
        return listRecipe.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listRecipe.size
    }

    class ViewHolder{
        lateinit var ivRecipe: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvLabel: TextView
        lateinit var tvDescription: TextView
    }
}