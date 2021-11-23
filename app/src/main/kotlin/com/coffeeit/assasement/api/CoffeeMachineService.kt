package com.coffeeit.assasement.api

import com.coffeeit.assasement.model.CoffeeMachine
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CoffeeMachineService {
    @GET("{machine_id}")
    fun machine(@Path("machine_id") machineId: String): Call<CoffeeMachine?>?
}