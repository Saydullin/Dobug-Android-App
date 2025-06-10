package com.saydullin.data.db.mapper.post

import com.saydullin.data.db.entity.post.PostTagEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.model.post.PostTag
import javax.inject.Inject

class PostTagToPostTagEntityMapper @Inject constructor(
): Mapper<PostTag, PostTagEntity> {

    override fun map(from: PostTag): PostTagEntity {
        return PostTagEntity(
            postId = from.postId,
            tagId = from.tagId
        )
    }

}