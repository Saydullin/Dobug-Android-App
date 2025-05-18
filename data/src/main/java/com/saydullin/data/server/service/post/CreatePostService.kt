package com.saydullin.data.server.service.post

import com.saydullin.domain.model.main.Content
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface CreatePostService {

    @Multipart
    @POST("createPost")
    fun createPost(
        @Part("preview_image") previewImage: MultipartBody.Part,
        @Part("authorId") authorId: RequestBody,
        @Part("content") content: RequestBody,
        @Part("status") status: RequestBody,
        @Part("tags") tags: RequestBody,
    ): Call<Content<Boolean>>

}