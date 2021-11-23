package com.coffeeit.assasement.model

import kotlinx.serialization.Serializable

@Serializable
data class CoffeeMachine(
    val _id: String,
    val types: Array<CoffeeType>,
    val sizes: Array<CoffeeSize>,
    val extras: Array<CoffeeExtra>
)