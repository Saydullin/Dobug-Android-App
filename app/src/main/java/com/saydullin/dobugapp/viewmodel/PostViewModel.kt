package com.saydullin.dobugapp.viewmodel

import androidx.lifecycle.ViewModel
import com.saydullin.data.paging.post.source.GetPostPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    getPostPagingSource: GetPostPagingSource,
): ViewModel() {

    val posts = getPostPagingSource.getPosts()

}


