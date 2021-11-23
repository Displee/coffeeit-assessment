package com.coffeeit.assasement.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object CoffeeMachineAPI {

    private val json = Json {
        ignoreUnknownKeys = true
    }
    val service: CoffeeMachineService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://darkroastedbeans.coffeeit.nl/coffee-machine/")
            .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
            .build()
        service = retrofit.create(CoffeeMachineService::class.java)
    }

}