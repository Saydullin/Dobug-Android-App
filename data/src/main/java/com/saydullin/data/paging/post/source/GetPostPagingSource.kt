package com.saydullin.data.paging.post.source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.saydullin.data.db.dao.post.PostDao
import com.saydullin.data.db.mapper.post.PostRelationToPostMapper
import com.saydullin.data.paging.post.mediator.PostRemoteMediator
import com.saydullin.domain.model.post.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPostPagingSource @Inject constructor(
    private val postDao: PostDao,
    private val postMapper: PostRelationToPostMapper,
    private val postRemoteMediator: PostRemoteMediator,
) {

    @OptIn(ExperimentalPagingApi::class)
    fun getPosts(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = postRemoteMediator,
            pagingSourceFactory = {
                postDao.getAllPosts()
            }
        ).flow
            .map { pagingData ->
                pagingData.map { postWithRelations ->
                    postMapper.map(postWithRelations)
                }
            }
    }

}