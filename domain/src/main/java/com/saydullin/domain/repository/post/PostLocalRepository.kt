package com.saydullin.domain.repository.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.util.resource.Resource

interface PostLocalRepository {

    suspend fun getPostById(postId: Long): Resource<Post>

    fun insert(posts: List<Post>): Resource<List<Long>>

    fun clear(): Resource<Int>

}


