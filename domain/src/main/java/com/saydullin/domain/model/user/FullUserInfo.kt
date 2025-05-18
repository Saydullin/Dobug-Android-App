package com.saydullin.domain.model.user

import com.saydullin.domain.model.education.Education
import com.saydullin.domain.model.experience.Experience
import com.saydullin.domain.model.image.ImagePreview
import com.saydullin.domain.model.location.Location
import com.saydullin.domain.model.profession.Profession
import com.saydullin.domain.model.project.Project
import com.saydullin.domain.model.resume.Resume

data class FullUserInfo(
    val id: Long,
    val firstName: String?,
    val middleName: String?,
    val lastName: String?,
    val username: String?,
    val password: String?,
    val imagePreview: ImagePreview?,
    val bio: String?,
    val followers: Long?,
    val following: Long?,
    val emailVerified: Boolean?,
    val email: String?,
    val createdAt: Long?,
    val deletedAt: Long?,
    val status: Int,
    val resume: Resume?,
    val location: Location?,
    val profession: Profession?,
    val educationList: List<Education> = emptyList(),
    val experienceList: List<Experience> = emptyList(),
    val projectList: List<Project> = emptyList()
)

