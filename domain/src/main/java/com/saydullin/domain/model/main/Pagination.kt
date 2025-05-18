package com.saydullin.domain.model.main

data class Pagination<T>(
    val pageNum: Int,
    val pageSize: Int,
    val totalItems: Int,
    val availableItems: Int,
    val items: List<T>
)
