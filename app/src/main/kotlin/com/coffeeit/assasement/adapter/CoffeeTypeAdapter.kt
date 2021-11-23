package com.coffeeit.assasement.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.activity.SelectYourSizeActivity
import com.coffeeit.assasement.model.CoffeeType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CoffeeTypeAdapter(var dataSet: Array<CoffeeType>) :
    RecyclerView.Adapter<CoffeeTypeAdapter.ViewHolder>() {

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
        val coffeeType = dataSet[position]
        val icon = when(coffeeType.name) {
            "Espresso" -> R.drawable.ic_espresso
            "Cappuccino" -> R.drawable.ic_cappuchino
            else -> null
        }
        if (icon != null) {
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, icon))
            viewHolder.imageView.visibility = View.VISIBLE
        } else {
            viewHolder.imageView.visibility = View.GONE
        }
        viewHolder.textView.text = coffeeType.name
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, SelectYourSizeActivity::class.java).apply {
                putExtra("coffeeType", Json.encodeToString(coffeeType))
            }
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount() = dataSet.size

}