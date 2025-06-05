package com.saydullin.data.db.mapper

interface Mapper<T, E> {

    fun map(from: T): E

    fun unmap(from: E): T

}