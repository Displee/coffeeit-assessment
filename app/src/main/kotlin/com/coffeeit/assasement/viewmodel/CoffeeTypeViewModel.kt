package com.coffeeit.assasement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coffeeit.assasement.model.CoffeeType
import com.coffeeit.assasement.repository.CoffeeMachineRepository

class CoffeeTypeViewModel : ViewModel() {

    private val coffeeTypes: MutableLiveData<Array<CoffeeType>> = CoffeeMachineRepository.coffeeTypes()

    fun coffeeTypes(): LiveData<Array<CoffeeType>> {
        return coffeeTypes
    }

}