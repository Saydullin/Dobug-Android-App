package com.saydullin.data.server.service.postComment

import com.saydullin.data.model.comment.NewComment
import com.saydullin.domain.model.main.Content
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostCommentService {

    @POST("updateComment")
    fun addComment(@Body newComment: NewComment): Call<Content<Boolean>>

}


