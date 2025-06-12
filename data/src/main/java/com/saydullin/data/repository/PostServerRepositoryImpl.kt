package com.saydullin.data.repository

import com.saydullin.data.server.service.post.PostService
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class PostServerRepositoryImpl @Inject constructor(
    private val postService: PostService
): PostServerRepository {

    override suspend fun getPosts(
        page: Int,
        pageLength: Int
    ): Resource<List<Post>> {
        return Resource.tryWithSuspend(Status.PostServerError) {
            val postsList = postService.getPosts(page, pageLength)

            // TODO Обработать ошибку и статус
            postsList.body()?.items ?: listOf()
        }
    }

    override suspend fun getPostById(postId: Long): Resource<Post> {
        TODO("Not yet implemented")
    }

}