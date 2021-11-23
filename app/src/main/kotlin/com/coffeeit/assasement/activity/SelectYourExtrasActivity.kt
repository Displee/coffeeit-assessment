package com.coffeeit.assasement.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeit.assasement.R
import com.coffeeit.assasement.adapter.CoffeeExtrasAdapter
import com.coffeeit.assasement.model.CoffeeExtra
import com.coffeeit.assasement.viewmodel.CoffeeExtrasViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SelectYourExtrasActivity : AppCompatActivity() {

    private lateinit var coffeeExtrasAdapter: CoffeeExtrasAdapter
    private lateinit var coffeeSizeViewModel: CoffeeExtrasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_your_extras)

        coffeeSizeViewModel = ViewModelProvider(this)[CoffeeExtrasViewModel::class.java]
        coffeeSizeViewModel.coffeeExtras().observe(this) {
            coffeeExtrasAdapter.dataSet = it
            coffeeExtrasAdapter.notifyDataSetChanged()
        }

        initCoffeeExtras()
        setContinueListener()
    }

    private fun initCoffeeExtras() {
        val recyclerView = findViewById<RecyclerView>(R.id.coffee_extras)
        recyclerView.layoutManager = LinearLayoutManager(this)
        coffeeExtrasAdapter = CoffeeExtrasAdapter(coffeeSizeViewModel.coffeeExtras().value ?: emptyArray())
        recyclerView.adapter = coffeeExtrasAdapter
    }

    private fun setContinueListener() {
        val button = findViewById<ConstraintLayout>(R.id.continue_extras)
        button.setOnClickListener {
            val intent = Intent(this, CoffeeOverviewActivity::class.java).apply {
                val intentExtras = intent.extras
                if (intentExtras != null) {
                    putExtras(intentExtras)
                }
                val subExtras = mutableListOf<CoffeeExtra>()
                for(extra in coffeeExtrasAdapter.dataSet) {
                    if (extra.subSelections.filter { it.selected }.isNotEmpty()) {
                        subExtras.add(extra)
                    }
                }
                putExtra("coffeeExtra", Json.encodeToString(subExtras))
            }
            startActivity(intent)
        }
    }

}