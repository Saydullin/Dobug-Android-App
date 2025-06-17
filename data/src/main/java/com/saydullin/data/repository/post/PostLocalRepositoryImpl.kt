package com.saydullin.data.repository.post

import com.saydullin.data.db.dao.author.AuthorDao
import com.saydullin.data.db.dao.author.AuthorProfessionDao
import com.saydullin.data.db.dao.post.PostDao
import com.saydullin.data.db.dao.postTag.PostTagDao
import com.saydullin.data.db.dao.profession.ProfessionDao
import com.saydullin.data.db.dao.tag.TagDao
import com.saydullin.data.db.mapper.author.AuthorProfessionEntityToAuthorProfessionMapper
import com.saydullin.data.db.mapper.author.AuthorProfessionToAuthorProfessionEntityMapper
import com.saydullin.data.db.mapper.author.AuthorToAuthorEntityMapper
import com.saydullin.data.db.mapper.post.PostRelationToPostMapper
import com.saydullin.data.db.mapper.post.PostTagToPostTagEntityMapper
import com.saydullin.data.db.mapper.post.PostToPostEntityMapper
import com.saydullin.data.db.mapper.profession.ProfessionEntityToProfessionMapper
import com.saydullin.data.db.mapper.profession.ProfessionToProfessionEntityMapper
import com.saydullin.data.db.mapper.tag.TagToTagEntityMapper
import com.saydullin.data.model.author.AuthorProfession
import com.saydullin.data.model.post.PostTag
import com.saydullin.domain.exception.DatabaseNotFound
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class PostLocalRepositoryImpl @Inject constructor(
    private val tagDao: TagDao,
    private val postDao: PostDao,
    private val authorDao: AuthorDao,
    private val postTagDao: PostTagDao,
    private val professionDao: ProfessionDao,
    private val authorProfessionDao: AuthorProfessionDao,
    private val postMapper: PostRelationToPostMapper,
    private val postEntityMapper: PostToPostEntityMapper,
    private val tagToTagEntityMapper: TagToTagEntityMapper,
    private val authorToAuthorEntityMapper: AuthorToAuthorEntityMapper,
    private val postTagToPostTagEntityMapper: PostTagToPostTagEntityMapper,
    private val professionEntityToProfessionMapper: ProfessionEntityToProfessionMapper,
    private val professionToProfessionEntityMapper: ProfessionToProfessionEntityMapper,
    private val authorProfessionToAuthorProfessionEntityMapper: AuthorProfessionToAuthorProfessionEntityMapper,
    private val authorProfessionEntityToAuthorProfessionMapper: AuthorProfessionEntityToAuthorProfessionMapper,
): PostLocalRepository {

    override suspend fun getPostById(postId: Long): Resource<Post> {
        return Resource.tryWith(Status.PostDatabaseSelectError) {
            val postEntity = postDao.getPostById(postId) ?: throw DatabaseNotFound("Post with id $postId")

            postMapper.map(postEntity)
        }
    }

    override fun insert(posts: List<Post>): Resource<List<Long>> {
        return Resource.tryWith(Status.PostDatabaseInsertError) {

            val tagEntityList = posts.flatMap { post ->
                post.tags.map {
                    tagToTagEntityMapper.map(it)
                }
            }
            val postTagList = posts.flatMap { post ->
                post.tags.map { tag ->
                    PostTag(
                        postId = post.id,
                        tagId = tag.id
                    )
                }
            }
            val authorProfessionList = posts.flatMap { post ->
                post.author.professions.map { profession ->
                    AuthorProfession(
                        authorId = post.author.id,
                        professionId = profession.id
                    )
                }
            }

            val postEntity = posts.map { postEntityMapper.map(it) }
            val authorEntity = posts.map { authorToAuthorEntityMapper.map(it.author) }
            val postTagEntityList = postTagList.map { postTagToPostTagEntityMapper.map(it) }
            val professionEntityList = posts.flatMap { it.author.professions.map { professionToProfessionEntityMapper.map(it) } }
            val authorProfessionEntityList = authorProfessionList.map { authorProfessionToAuthorProfessionEntityMapper.map(it) }

            var postInsert = listOf<Long>()

            try {
                // TODO Add error handler
                authorDao.insert(authorEntity)
                professionDao.insert(professionEntityList)
                authorProfessionDao.insert(authorProfessionEntityList)
                postInsert = postDao.insert(postEntity)
                tagDao.insert(tagEntityList)
                postTagDao.insert(postTagEntityList)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            postInsert
        }
    }

    override fun clear(): Resource<Int> {
        return Resource.tryWith(Status.PostDatabaseDeleteError) {
            postDao.clear()
        }
    }

}


