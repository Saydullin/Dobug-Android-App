package com.saydullin.domain.usecase.post

import com.saydullin.domain.model.post.PostPreview
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.util.resource.Resource

class GetPostUseCase(
    private val postRepository: PostRepository
) {

    suspend fun execute(page: Int, pageLength: Int): Resource<List<PostPreview>> {
        return postRepository.getAllPost(page, pageLength)
    }

}