package com.saydullin.domain.model.location

import java.math.BigDecimal

data class Location(
    val id: Int,
    val title: String?,
    val description: String?,
    val longitude: BigDecimal?,
    val latitude: BigDecimal?
)