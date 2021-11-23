package com.coffeeit.assasement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coffeeit.assasement.model.CoffeeExtra
import com.coffeeit.assasement.repository.CoffeeMachineRepository

class CoffeeExtrasViewModel : ViewModel() {

    private val coffeeExtras: MutableLiveData<Array<CoffeeExtra>> = CoffeeMachineRepository.coffeeExtras()

    fun coffeeExtras(): LiveData<Array<CoffeeExtra>> {
        return coffeeExtras
    }

}