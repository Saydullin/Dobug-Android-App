package com.saydullin.data.db.mapper.profession

import com.saydullin.data.db.entity.profession.ProfessionEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.profession.Profession
import javax.inject.Inject

class ProfessionEntityToProfessionMapper @Inject constructor(
): Mapper<ProfessionEntity, Profession> {

    override fun map(from: ProfessionEntity): Profession {
        return Profession(
            id = from.id,
            title = from.title
        )
    }

}