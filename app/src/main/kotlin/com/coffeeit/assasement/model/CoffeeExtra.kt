package com.coffeeit.assasement.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeExtra(
    val _id: String,
    val name: String,
    @SerialName("subselections")
    val subSelections: Array<CoffeeExtra> = emptyArray()
) {
    var selected = false
}