package com.saydullin.domain.model.post

import com.saydullin.domain.model.author.Author
import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.tag.Tag

data class PostPreview(
    val id: Long,
    val content: String,
    val tags: List<Tag>,
    val views: Long,
    val likes: Long,
    val reposts: Long,
    val comments: Long,
    val createdAt: Long,
    val updatedAt: Long,
    val status: Int,
    val imagePreview: ImagePreview,
    val author: Author
)


