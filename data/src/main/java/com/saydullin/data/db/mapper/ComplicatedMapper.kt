package com.saydullin.data.db.mapper

interface ComplicatedMapper<B, T, E> {

    fun map(from: B): E

    fun unmap(from: E): T

}