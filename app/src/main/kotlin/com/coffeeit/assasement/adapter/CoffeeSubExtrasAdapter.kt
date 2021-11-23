package com.coffeeit.assasement.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.model.CoffeeExtra

class CoffeeSubExtrasAdapter(var dataSet: Array<CoffeeExtra>, private val intentExtras: Bundle?) :
    RecyclerView.Adapter<CoffeeSubExtrasAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.icon)
        val textView: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.coffee_extra, viewGroup, false)
        this.context = viewGroup.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val coffeeExtra = dataSet[position]
        if (coffeeExtra.selected) {
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_check))
        } else {
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_empty))
        }
        viewHolder.textView.text = coffeeExtra.name
        viewHolder.itemView.setOnClickListener {
            for(i in dataSet) {
                i.selected = false
            }
            coffeeExtra.selected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = dataSet.size

}