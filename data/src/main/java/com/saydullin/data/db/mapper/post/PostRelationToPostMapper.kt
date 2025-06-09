package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.db.mapper.author.AuthorEntityToAuthorMapper
import com.saydullin.data.db.mapper.tag.TagEntityToTagMapper
import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostRelationToPostMapper @Inject constructor(
    private val tagEntityToTagMapper: TagEntityToTagMapper,
    private val authorEntityToAuthorMapper: AuthorEntityToAuthorMapper,
): Mapper<PostWithRelations, Post> {

    override fun map(from: PostWithRelations): Post {
        return Post(
            id = from.postEntity.id,
            content = from.postEntity.content,
            tags = from.tags.map { tagEntityToTagMapper.map(it) },
            views = from.postEntity.views,
            likes = from.postEntity.likes,
            reposts = from.postEntity.reposts,
            comments = from.postEntity.comments,
            createdAt = from.postEntity.createdAt,
            updatedAt = from.postEntity.updatedAt,
            status = from.postEntity.status,
            imagePreview = ImagePreview(0L, ""), // TODO Добавить отношение один ко многим
            author = authorEntityToAuthorMapper.map(from.author)
        )
    }

}


