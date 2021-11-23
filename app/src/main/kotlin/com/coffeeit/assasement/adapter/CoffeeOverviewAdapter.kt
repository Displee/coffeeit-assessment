package com.coffeeit.assasement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.coffeeit.assasement.R
import com.coffeeit.assasement.model.CoffeeExtra
import java.util.*

class CoffeeOverviewAdapter(var dataSet: Array<CoffeeExtra>) :
    RecyclerView.Adapter<CoffeeOverviewAdapter.ViewHolder>() {

    private lateinit var context: Context
    private val viewPool = RecycledViewPool()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.icon)
        val textView: TextView = view.findViewById(R.id.text)
        val subExtras: RecyclerView = view.findViewById(R.id.coffee_sub_extras)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.coffee_item, viewGroup, false)
        this.context = viewGroup.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val coffeeExtra = dataSet[position]
        val name = coffeeExtra.name.lowercase(Locale.getDefault())
        val icon = when {
            name == "espresso" -> R.drawable.ic_espresso
            name == "cappuccino" -> R.drawable.ic_cappuchino
            name == "small" || name == "tall" -> R.drawable.ic_lungo_small
            name == "medium" || name == "grande" -> R.drawable.ic_lungo_medium
            name == "large" || name == "venti" -> R.drawable.ic_lungo_large
            name.contains("milk") -> {
                R.drawable.ic_milk
            }
            name.contains("sugar") -> {
                R.drawable.ic_cappuchino
            }
            else -> {
                null
            }
        }
        if (icon != null) {
            viewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, icon))
            viewHolder.imageView.visibility = View.VISIBLE
        } else {
            viewHolder.imageView.visibility = View.GONE
        }
        viewHolder.textView.text = coffeeExtra.name

        // Child recycler view
        val subSelections = coffeeExtra.subSelections.filter { it.selected }.toTypedArray()
        if (subSelections.isEmpty()) {
            return
        }
        val layoutManager = LinearLayoutManager(viewHolder.subExtras.context)
        val childItemAdapter = CoffeeSubExtrasAdapter(subSelections, false)
        viewHolder.subExtras.layoutManager = layoutManager
        viewHolder.subExtras.adapter = childItemAdapter
        viewHolder.subExtras.setRecycledViewPool(viewPool)
        viewHolder.subExtras.visibility = View.VISIBLE
    }

    override fun getItemCount() = dataSet.size

}