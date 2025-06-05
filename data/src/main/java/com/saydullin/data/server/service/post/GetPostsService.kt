package com.saydullin.data.server.service.post

import com.saydullin.domain.model.main.Content
import com.saydullin.domain.model.main.Pagination
import com.saydullin.domain.model.post.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPostsService {

    @GET("posts")
    fun getAllPosts(
        @Query("page") page: Int,
        @Query("pageLength") pageLength: Int,
    ): Call<Content<Pagination<Post>>>

}


