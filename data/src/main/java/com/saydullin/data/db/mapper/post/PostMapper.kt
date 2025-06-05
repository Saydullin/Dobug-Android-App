package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.mapper.ComplicatedMapper
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.tag.Tag
import javax.inject.Inject

class PostRelationAndPostEntityMapper @Inject constructor(

): ComplicatedMapper<PostWithRelations, PostEntity, Post> {

    override fun map(from: PostWithRelations): Post {
        return Post(
            id = from.postEntity.id,
            content = from.postEntity.content,
            tags = from.tags,
            views = from.postEntity.views,
            likes = from.postEntity.likes,
            reposts = from.postEntity.reposts,
            comments = from.postEntity.comments,
            createdAt = from.postEntity.createdAt,
            updatedAt = from.postEntity.updatedAt,
            status = from.postEntity.status,
            imagePreview = from.imagePreview,
            author = from.author
        )
    }

    override fun unmap(from: Post): PostEntity {
        return PostEntity(
            id = from.id,
            content = from.content,
            tagPostId = extractTagPostId(from.tags),
            views = from.views,
            likes = from.likes,
            reposts = from.reposts,
            comments = from.comments,
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            status = from.status,
            imageId = from.imagePreview.id,
            authorId = from.author.id
        )
    }

    private fun extractTagPostId(tags: List<Tag>): Long {
        return tags.firstOrNull()?.id ?: 0L
    }

}