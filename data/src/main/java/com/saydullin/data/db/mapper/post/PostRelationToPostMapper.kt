package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.db.mapper.author.AuthorWithProfessionEntityToAuthorMapper
import com.saydullin.data.db.mapper.tag.TagEntityToTagMapper
import com.saydullin.data.model.author.AuthorWithProfessionEntity
import com.saydullin.domain.model.author.Author
import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostRelationToPostMapper @Inject constructor(
    private val tagEntityToTagMapper: TagEntityToTagMapper,
    private val authorWithProfessionEntityToAuthorMapper: AuthorWithProfessionEntityToAuthorMapper,
): Mapper<PostWithRelations, Post> {

    override fun map(from: PostWithRelations): Post {

        val author = if (from.author != null) {
            val authorWithProfessionEntity = AuthorWithProfessionEntity(
                author = from.author,
                professions = from.professions
            )

            authorWithProfessionEntityToAuthorMapper.map(authorWithProfessionEntity)
        } else {
            Author.getAnonymous()
        }

        return Post(
            id = from.postEntity.id,
            content = from.postEntity.content,
            tags = from.tags.map { tagEntityToTagMapper.map(it) },
            views = from.postEntity.views,
            likes = from.postEntity.likes,
            reposts = from.postEntity.reposts,
            comments = from.postEntity.comments,
            createdAt = from.postEntity.createdAt.toString(),
            updatedAt = from.postEntity.updatedAt.toString(),
            status = from.postEntity.status,
            imagePreview = ImagePreview(0L, ""),
            author = author
        )
    }

}


