package com.saydullin.domain.repository

import com.saydullin.domain.model.post.PostPreview
import com.saydullin.domain.util.resource.Resource

interface PostRepository {

    suspend fun getAllPost(
        page: Int,
        pageLength: Int
    ): Resource<List<PostPreview>>

    suspend fun getPostById(postId: Long): Resource<PostPreview>

}


