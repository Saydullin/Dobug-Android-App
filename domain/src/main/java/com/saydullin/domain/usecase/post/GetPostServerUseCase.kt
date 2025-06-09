package com.saydullin.domain.usecase.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.util.resource.Resource

class GetPostServerUseCase(
    private val postServerRepository: PostServerRepository
) {

    suspend fun execute(page: Int, pageLength: Int): Resource<List<Post>> {
        return postServerRepository.getAllPost(page, pageLength)
    }

}