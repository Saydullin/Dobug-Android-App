package com.saydullin.data.db.mapper.profession

import com.saydullin.data.db.entity.profession.ProfessionEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.profession.Profession
import javax.inject.Inject

class ProfessionToProfessionEntityMapper @Inject constructor(
): Mapper<Profession, ProfessionEntity> {

    override fun map(from: Profession): ProfessionEntity {
        return ProfessionEntity(
            id = from.id,
            title = from.title
        )
    }

}