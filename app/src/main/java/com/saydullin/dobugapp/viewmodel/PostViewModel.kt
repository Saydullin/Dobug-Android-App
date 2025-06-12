package com.saydullin.dobugapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.data.paging.post.mediator.PostRemoteMediator
import com.saydullin.data.paging.post.source.GetPostPagingSource
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    getPostPagingSource: GetPostPagingSource,
    private val postRemoteMediator: PostRemoteMediator,
): ViewModel() {

    private val _error = MutableStateFlow<Resource.Error<Unit>?>(null)
    val error: StateFlow<Resource.Error<Unit>?> = _error

    val posts = getPostPagingSource.getPosts()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postRemoteMediator.error.collect { errorString ->
                _error.value = Resource.Error(
                    status = Status.UNAUTHORIZED,
                    message = errorString ?: ""
                )
            }
        }
    }

}


