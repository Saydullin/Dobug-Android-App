package com.saydullin.data.db.entity.profession

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "profession"
)
data class ProfessionEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val title: String,
)


