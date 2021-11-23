package com.coffeeit.assasement.repository

import androidx.lifecycle.MutableLiveData
import com.coffeeit.assasement.api.CoffeeMachineAPI
import com.coffeeit.assasement.model.CoffeeExtra
import com.coffeeit.assasement.model.CoffeeMachine
import com.coffeeit.assasement.model.CoffeeSize
import com.coffeeit.assasement.model.CoffeeType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val MACHINE_ID = "60ba1ab72e35f2d9c786c610"

object CoffeeMachineRepository {

    private var coffeeMachine: CoffeeMachine? = null

    fun coffeeTypes(): MutableLiveData<Array<CoffeeType>> {
        val data = MutableLiveData<Array<CoffeeType>>()
        if (coffeeMachine == null) {
            CoffeeMachineAPI.service.machine(MACHINE_ID)
                ?.enqueue(object : Callback<CoffeeMachine?> {
                    override fun onResponse(
                        call: Call<CoffeeMachine?>,
                        response: Response<CoffeeMachine?>
                    ) {
                        val body = response.body() ?: return
                        coffeeMachine = body
                        data.postValue(body.types)
                    }

                    override fun onFailure(call: Call<CoffeeMachine?>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        } else {
            data.value = coffeeMachine!!.types
        }
        return data
    }

    fun coffeeSizes(): MutableLiveData<Array<CoffeeSize>> {
        val data = MutableLiveData<Array<CoffeeSize>>()
        if (coffeeMachine == null) {
            CoffeeMachineAPI.service.machine(MACHINE_ID)
                ?.enqueue(object : Callback<CoffeeMachine?> {
                    override fun onResponse(
                        call: Call<CoffeeMachine?>,
                        response: Response<CoffeeMachine?>
                    ) {
                        val body = response.body() ?: return
                        coffeeMachine = body
                        data.postValue(body.sizes)
                    }

                    override fun onFailure(call: Call<CoffeeMachine?>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        } else {
            data.value = coffeeMachine!!.sizes
        }
        return data
    }

    fun coffeeExtras(): MutableLiveData<Array<CoffeeExtra>> {
        val data = MutableLiveData<Array<CoffeeExtra>>()
        if (coffeeMachine == null) {
            CoffeeMachineAPI.service.machine(MACHINE_ID)
                ?.enqueue(object : Callback<CoffeeMachine?> {
                    override fun onResponse(
                        call: Call<CoffeeMachine?>,
                        response: Response<CoffeeMachine?>
                    ) {
                        val body = response.body() ?: return
                        coffeeMachine = body
                        data.postValue(body.extras)
                    }

                    override fun onFailure(call: Call<CoffeeMachine?>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        } else {
            data.value = coffeeMachine!!.extras
        }
        return data
    }

}