package com.saydullin.domain.model.project

import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.tag.Tag

data class Project(
    val id: Long,
    val title: String?,
    val description: String?,
    val imagePreview: ImagePreview?,
    val tagList: List<Tag> = emptyList(),
//    val userSignUp: UserSignUp?, TODO
    val createdAt: Long?,
    val editedAt: Long?,
    val deletedAt: Long?,
    val status: Int
)