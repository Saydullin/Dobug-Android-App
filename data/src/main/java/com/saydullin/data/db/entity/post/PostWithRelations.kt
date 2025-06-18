package com.saydullin.data.db.entity.post

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.entity.author.AuthorProfessionEntity
import com.saydullin.data.db.entity.author.AuthorWithRelations
import com.saydullin.data.db.entity.media.MediaEntity
import com.saydullin.data.db.entity.profession.ProfessionEntity
import com.saydullin.data.db.entity.tag.TagEntity

data class PostWithRelations(
    @Embedded
    val postEntity: PostEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PostTagEntity::class,
            parentColumn = "postId",
            entityColumn = "tagId",
        )
    )
    val tags: List<TagEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PostMediaEntity::class,
            parentColumn = "postId",
            entityColumn = "mediaId",
        )
    )
    val imagePreview: List<MediaEntity>,
    @Relation(
        entity = AuthorEntity::class,
        parentColumn = "author_id",
        entityColumn = "id"
    )
    val author: AuthorWithRelations?,
)


