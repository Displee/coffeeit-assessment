package com.coffeeit.assasement.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coffeeit.assasement.model.CoffeeExtra
import com.coffeeit.assasement.model.CoffeeSize
import com.coffeeit.assasement.model.CoffeeType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CoffeeOverviewViewModel : ViewModel() {

    fun overview(intentExtra: Bundle?): LiveData<Array<CoffeeExtra>> {
        val liveData = MutableLiveData<Array<CoffeeExtra>>()
        if (intentExtra != null) {
            val coffeeType: CoffeeType = Json.decodeFromString(intentExtra.getString("coffeeType") ?: "")
            val coffeeSize: CoffeeSize = Json.decodeFromString(intentExtra.getString("coffeeSize") ?: "")
            val coffeeExtra: Array<CoffeeExtra> = Json.decodeFromString(intentExtra.getString("coffeeExtra") ?: "")
            liveData.value = arrayOf(
                CoffeeExtra(coffeeType._id, coffeeType.name),
                CoffeeExtra(coffeeSize._id, coffeeSize.name),
                *coffeeExtra
            )
        }
        return liveData
    }

}