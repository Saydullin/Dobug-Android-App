package com.saydullin.domain.model.experience

import com.saydullin.domain.model.profession.Profession

data class Experience(
    val id: Long,
    val companyTitle: String?,
    val description: String?,
    val profession: Profession?,
    val startedAt: Long?,
    val endedAt: Long?,
    val format: Int,
    val type: Int
)