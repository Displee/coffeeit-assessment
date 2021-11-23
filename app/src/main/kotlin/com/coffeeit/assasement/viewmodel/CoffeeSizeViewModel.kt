package com.coffeeit.assasement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coffeeit.assasement.model.CoffeeSize
import com.coffeeit.assasement.repository.CoffeeMachineRepository

class CoffeeSizeViewModel : ViewModel() {

    private val coffeeSizes: MutableLiveData<Array<CoffeeSize>> = CoffeeMachineRepository.coffeeSizes()

    fun coffeeSizes(): LiveData<Array<CoffeeSize>> {
        return coffeeSizes
    }

}