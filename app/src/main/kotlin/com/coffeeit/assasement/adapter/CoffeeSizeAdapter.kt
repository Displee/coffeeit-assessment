package com.coffeeit.assasement.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.activity.SelectYourExtrasActivity
import com.coffeeit.assasement.model.CoffeeSize
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CoffeeSizeAdapter(var dataSet: Array<CoffeeSize>, private val intentExtras: Bundle?) :
    RecyclerView.Adapter<CoffeeSizeAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.icon)
        val textView: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.coffee_item, viewGroup, false)
        this.context = viewGroup.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val coffeeSize = dataSet[position]
        val icon = when(coffeeSize.name) {
            "Small", "Tall" -> R.drawable.ic_lungo_small
            "Medium", "Grande" -> R.drawable.ic_lungo_medium
            "Large", "Venti" -> R.drawable.ic_lungo_large
            else -> null
        }
        if (icon != null) {
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, icon))
            viewHolder.imageView.visibility = View.VISIBLE
        } else {
            viewHolder.imageView.visibility = View.GONE
        }
        viewHolder.textView.text = coffeeSize.name
        viewHolder.itemView.setOnClickListener {
            println(it)
            val intent = Intent(context, SelectYourExtrasActivity::class.java).apply {
                if (intentExtras != null) {
                    putExtras(intentExtras)
                }
                putExtra("coffeeSize", Json.encodeToString(coffeeSize))
            }
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount() = dataSet.size

}