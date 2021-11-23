package com.coffeeit.assasement.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.adapter.CoffeeTypeAdapter
import com.coffeeit.assasement.viewmodel.CoffeeTypeViewModel

class SelectYourStyleActivity : AppCompatActivity() {

    private lateinit var coffeeTypeAdapter: CoffeeTypeAdapter
    private lateinit var coffeeTypeViewModel: CoffeeTypeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_your_style)

        coffeeTypeViewModel = ViewModelProvider(this)[CoffeeTypeViewModel::class.java]
        coffeeTypeViewModel.coffeeTypes().observe(this) {
            coffeeTypeAdapter.dataSet = it
            coffeeTypeAdapter.notifyDataSetChanged()
        }

        initCoffeeTypes()
    }

    private fun initCoffeeTypes() {
        val recyclerView = findViewById<RecyclerView>(R.id.coffee_styles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        coffeeTypeAdapter = CoffeeTypeAdapter(coffeeTypeViewModel.coffeeTypes().value ?: emptyArray())
        recyclerView.adapter = coffeeTypeAdapter
    }

}