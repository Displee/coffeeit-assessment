package com.coffeeit.assasement.model

import kotlinx.serialization.Serializable

@Serializable
data class CoffeeSize(
    val _id: String,
    val name: String,
)