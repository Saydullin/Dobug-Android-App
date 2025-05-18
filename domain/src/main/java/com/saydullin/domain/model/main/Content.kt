package com.saydullin.domain.model.main

data class Content<T>(
    val date: Long,
    val request: String,
    val data: T,
    val isSuccess: Boolean
)
