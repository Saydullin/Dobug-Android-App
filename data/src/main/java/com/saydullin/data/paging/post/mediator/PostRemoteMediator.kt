package com.saydullin.data.paging.post.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.saydullin.data.db.AppDatabase
import com.saydullin.data.db.dao.post.RemotePostKeysDao
import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.entity.post.paging.RemotePostKeysEntity
import com.saydullin.data.server.service.post.PostService
import com.saydullin.domain.repository.post.PostLocalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator @Inject constructor(
    private val postLocalRepository: PostLocalRepository,
    private val postService: PostService,
    private val remotePostKeysDao: RemotePostKeysDao,
    private val appDatabase: AppDatabase,
): RemoteMediator<Int, PostWithRelations>() {

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    override suspend fun load(loadType: LoadType, state: PagingState<Int, PostWithRelations>): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)

                remoteKeys?.nextKey?.minus(1) ?: 1
            }

            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey

                prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }

            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey

                nextKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val postsResponse = postService.getPosts(page, state.config.pageSize)

            if (!postsResponse.isSuccessful || postsResponse.body() == null) {
                _error.value = "${postsResponse.code()}"

                println("PostsRemoteMediator ${postsResponse.code()}")

                return MediatorResult.Error(HttpException(postsResponse))
            }

            val posts = postsResponse.body()?.items ?: listOf()
            val endOfPaginationReached = posts.size < state.config.pageSize

            appDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remotePostKeysDao.clear()
                    postLocalRepository.clear()
                }
                val keys = posts.map {
                    RemotePostKeysEntity(
                        postId = it.id,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (endOfPaginationReached) null else page + 1
                    )
                }
                remotePostKeysDao.insertAll(keys)
                postLocalRepository.insert(posts)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, PostWithRelations>): RemotePostKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { user -> remotePostKeysDao.remoteKeysUserId(user.postEntity.id) }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, PostWithRelations>): RemotePostKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { user -> remotePostKeysDao.remoteKeysUserId(user.postEntity.id) }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PostWithRelations>): RemotePostKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.postEntity?.id?.let { userId ->
                remotePostKeysDao.remoteKeysUserId(userId)
            }
        }
    }

}


