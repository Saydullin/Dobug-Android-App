package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.tag.Tag
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
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            status = from.status,
            authorId = from.author.id
        )
    }

}


