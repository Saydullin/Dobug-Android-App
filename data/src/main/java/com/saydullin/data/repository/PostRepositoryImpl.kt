package com.saydullin.data.repository

import com.saydullin.data.server.service.post.GetPostsService
import com.saydullin.domain.model.post.PostPreview
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val getPostsService: GetPostsService
): PostRepository {

    override suspend fun getAllPost(
        page: Int,
        pageLength: Int
    ): Resource<List<PostPreview>> {
        return Resource.tryWith(Status.PostServerError) {
            val postsListRequest = getPostsService.getAllPosts(page, pageLength)

            val postsList = postsListRequest.execute()

            // TODO Обработать ошибку и статус
            postsList.body()?.data?.items ?: listOf()
        }
    }

    override suspend fun getPostById(postId: Long): Resource<PostPreview> {
        TODO("Not yet implemented")
    }

}