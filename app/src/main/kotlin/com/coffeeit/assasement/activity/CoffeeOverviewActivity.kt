package com.coffeeit.assasement.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.adapter.CoffeeOverviewAdapter
import com.coffeeit.assasement.viewmodel.CoffeeOverviewViewModel

class CoffeeOverviewActivity : AppCompatActivity() {

    private lateinit var coffeeOverviewAdapter: CoffeeOverviewAdapter
    private lateinit var coffeeOverviewViewModel: CoffeeOverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        coffeeOverviewViewModel = ViewModelProvider(this)[CoffeeOverviewViewModel::class.java]

        initCoffeeOverview()
    }

    private fun initCoffeeOverview() {
        val recyclerView = findViewById<RecyclerView>(R.id.coffee_extras)
        recyclerView.layoutManager = LinearLayoutManager(this)
        coffeeOverviewAdapter = CoffeeOverviewAdapter(coffeeOverviewViewModel.overview(intent.extras).value ?: emptyArray())
        recyclerView.adapter = coffeeOverviewAdapter
    }

}