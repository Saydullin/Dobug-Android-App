package com.saydullin.data.db.entity.post

import com.saydullin.domain.model.author.Author
import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.tag.Tag

data class PostWithRelations(
    val postEntity: PostEntity,
    val tags: List<Tag>,
    val imagePreview: ImagePreview,
    val author: Author,
)
