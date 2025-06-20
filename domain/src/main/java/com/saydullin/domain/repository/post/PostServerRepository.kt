package com.saydullin.domain.repository.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.util.resource.Resource

interface PostServerRepository {

    suspend fun getPosts(
        page: Int,
        pageLength: Int
    ): Resource<List<Post>>

    suspend fun getPostById(postId: Long): Resource<Post>

}


