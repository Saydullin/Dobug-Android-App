package com.saydullin.data.server.service.postLike

import com.saydullin.data.model.common.PostAndAuthor
import com.saydullin.domain.model.main.Content
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostLikeService {

    @POST("postLike")
    fun postLike(@Body postAndAuthor: PostAndAuthor): Call<Content<Unit>>

}