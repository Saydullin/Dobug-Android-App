package com.saydullin.data.model.comment

data class NewComment(
    val content: String,
    val postId: Long,
    val authorId: Long,
)
