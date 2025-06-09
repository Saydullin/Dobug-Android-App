package com.saydullin.data.repository

import com.saydullin.data.db.dao.PostDao
import com.saydullin.data.db.mapper.post.PostRelationToPostMapper
import com.saydullin.data.db.mapper.post.PostToPostEntityMapper
import com.saydullin.domain.exception.DatabaseNotFound
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class PostLocalRepositoryImpl @Inject constructor(
    private val postDao: PostDao,
    private val postMapper: PostRelationToPostMapper,
    private val postEntityMapper: PostToPostEntityMapper,
): PostLocalRepository {

    override suspend fun getPostById(postId: Long): Resource<Post> {
        return Resource.tryWith(Status.PostDatabaseSelectError) {
            val postEntity = postDao.getPostById(postId) ?: throw DatabaseNotFound("Post with id $postId")

            postMapper.map(postEntity)
        }
    }

    override fun insert(posts: List<Post>): Resource<List<Long>> {
        return Resource.tryWith(Status.PostDatabaseInsertError) {
            val postEntity = posts.map { postEntityMapper.map(it) }

            postDao.insert(postEntity)
        }
    }

    override fun clear(): Resource<Int> {
        return Resource.tryWith(Status.PostDatabaseDeleteError) {
            postDao.clear()
        }
    }

}


