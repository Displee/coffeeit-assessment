package com.coffeeit.assasement.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.adapter.CoffeeSizeAdapter
import com.coffeeit.assasement.viewmodel.CoffeeSizeViewModel

class SelectYourSizeActivity : AppCompatActivity() {

    private lateinit var coffeeSizeAdapter: CoffeeSizeAdapter
    private lateinit var coffeeSizeViewModel: CoffeeSizeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_your_size)

        coffeeSizeViewModel = ViewModelProvider(this)[CoffeeSizeViewModel::class.java]
        coffeeSizeViewModel.coffeeSizes().observe(this) {
            coffeeSizeAdapter.dataSet = it
            coffeeSizeAdapter.notifyDataSetChanged()
        }

        initCoffeeSizes()
    }

    private fun initCoffeeSizes() {
        val recyclerView = findViewById<RecyclerView>(R.id.coffee_sizes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        coffeeSizeAdapter = CoffeeSizeAdapter(coffeeSizeViewModel.coffeeSizes().value ?: emptyArray(), intent.extras)
        recyclerView.adapter = coffeeSizeAdapter
    }

}