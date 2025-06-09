package com.saydullin.data.db.mapper.tag

import com.saydullin.data.db.entity.tag.TagEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.tag.Tag
import javax.inject.Inject

class TagEntityToTagMapper @Inject constructor(
): Mapper<TagEntity, Tag> {

    override fun map(from: TagEntity): Tag {
        return Tag(
            id = from.id,
            title = from.title
        )
    }

}