package com.saydullin.data.server.service.post

import com.saydullin.domain.model.main.Content
import com.saydullin.domain.model.main.Pagination
import com.saydullin.domain.model.post.Post
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("pageLength") pageLength: Int,
    ): Response<Pagination<Post>>

    @Multipart
    @POST("createPost")
    suspend fun createPost(
        @Part("preview_image") previewImage: MultipartBody.Part,
        @Part("authorId") authorId: RequestBody,
        @Part("content") content: RequestBody,
        @Part("status") status: RequestBody,
        @Part("tags") tags: RequestBody,
    ): Response<Content<Boolean>>

}


