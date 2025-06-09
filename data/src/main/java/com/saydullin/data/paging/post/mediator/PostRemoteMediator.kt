package com.saydullin.data.paging.post.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.saydullin.data.db.AppDatabase
import com.saydullin.data.db.dao.RemoteKeysDao
import com.saydullin.data.db.entity.post.PostWithRelations
import com.saydullin.data.db.entity.post.paging.RemoteKeysEntity
import com.saydullin.data.server.service.post.PostService
import com.saydullin.domain.repository.post.PostLocalRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator @Inject constructor(
    private val postLocalRepository: PostLocalRepository,
    private val postService: PostService,
    private val remoteKeysDao: RemoteKeysDao,
    private val appDatabase: AppDatabase,
): RemoteMediator<Int, PostWithRelations>() {

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
            val postsCall = postService.getPosts(page, state.config.pageSize)
            val postsResponse = postsCall.execute()
            val posts = postsResponse.body()?.data?.items ?: listOf()
            val endOfPaginationReached = posts.isEmpty()

            appDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeysDao.clear()
                    postLocalRepository.clear()
                }
                val keys = posts.map {
                    RemoteKeysEntity(
                        userId = it.id,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (endOfPaginationReached) null else page + 1
                    )
                }
                remoteKeysDao.insertAll(keys)
                postLocalRepository.insert(posts)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private fun getRemoteKeyForLastItem(state: PagingState<Int, PostWithRelations>): RemoteKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { user -> remoteKeysDao.remoteKeysUserId(user.postEntity.id) }
    }

    private fun getRemoteKeyForFirstItem(state: PagingState<Int, PostWithRelations>): RemoteKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { user -> remoteKeysDao.remoteKeysUserId(user.postEntity.id) }
    }

    private fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PostWithRelations>): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.postEntity?.id?.let { userId ->
                remoteKeysDao.remoteKeysUserId(userId)
            }
        }
    }

}


