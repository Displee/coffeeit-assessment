package com.coffeeit.assasement.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.adapter.CoffeeOverviewAdapter
import com.coffeeit.assasement.viewmodel.CoffeeOverviewViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import com.coffeeit.assasement.ui.divider.DividerItemDecorator

class CoffeeOverviewActivity : AppCompatActivity() {

    private lateinit var coffeeOverviewAdapter: CoffeeOverviewAdapter
    private lateinit var coffeeOverviewViewModel: CoffeeOverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        coffeeOverviewViewModel = ViewModelProvider(this)[CoffeeOverviewViewModel::class.java]

        initCoffeeOverview()

        val brewButton = findViewById<ConstraintLayout>(R.id.brew_coffee)
        brewButton?.setOnClickListener {
            println("Brew!")
        }
    }

    private fun initCoffeeOverview() {
        val recyclerView = findViewById<RecyclerView>(R.id.coffee_extras)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        coffeeOverviewAdapter = CoffeeOverviewAdapter(
            coffeeOverviewViewModel.overview(intent.extras).value ?: emptyArray()
        )
        recyclerView.adapter = coffeeOverviewAdapter
        val dividerItemDecoration =
            DividerItemDecorator(ContextCompat.getDrawable(this, R.drawable.divider_layer)!!)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

}