package com.saydullin.data.db.mapper.tag

import com.saydullin.data.db.entity.tag.TagEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.tag.Tag
import javax.inject.Inject

class TagToTagEntityMapper @Inject constructor(
): Mapper<Tag, TagEntity> {

    override fun map(from: Tag): TagEntity {
        return TagEntity(
            id = from.id,
            title = from.title
        )
    }

}