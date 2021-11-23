package com.coffeeit.assasement.model

import kotlinx.serialization.Serializable

@Serializable
data class CoffeeType(
    val _id: String,
    val name: String,
    val sizes: Array<String>,
    val extras: Array<String>
)