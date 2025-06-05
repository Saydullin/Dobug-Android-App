package com.saydullin.data.repository

import com.saydullin.data.db.dao.PostDao
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class PostLocalRepositoryImpl @Inject constructor(
    private val postDao: PostDao
): PostLocalRepository {

    override suspend fun getAllPost(
        page: Int,
        pageLength: Int
    ): Resource<List<Post>> {
        return Resource.tryWith(Status.PostServerError) {
            val postEntityList = postDao.getAllPosts()

            // TODO Lj,fd
            listOf()
        }
    }

    override suspend fun getPostById(postId: Long): Resource<Post> {
        TODO("Not yet implemented")
    }

}


