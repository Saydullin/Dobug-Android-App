package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.ext.parseIsoDateToMillis
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostToPostEntityMapper @Inject constructor(
): Mapper<Post, PostEntity> {

    override fun map(from: Post): PostEntity {
        return PostEntity(
            id = from.id,
            content = from.content,
            views = from.views,
            likes = from.likes,
            reposts = from.reposts,
            comments = from.comments,
            createdAt = parseIsoDateToMillis(from.createdAt),
            updatedAt = parseIsoDateToMillis(from.updatedAt),
            status = from.status,
            authorId = from.author.id,
            imagePreviewId = from.imagePreview.id,
            imagePreviewPath = from.imagePreview.imagePath ?: "",
        )
    }

}


