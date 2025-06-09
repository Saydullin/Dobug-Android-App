package com.saydullin.data.db.entity.tag

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag")
data class TagEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val title: String,
)