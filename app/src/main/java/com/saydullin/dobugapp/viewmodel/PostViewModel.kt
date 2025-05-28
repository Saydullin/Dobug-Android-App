package com.saydullin.dobugapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.post.PostPreview
import com.saydullin.domain.usecase.post.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
): ViewModel() {

    private val _posts = MutableStateFlow<List<PostPreview>?>(null)
    val posts: StateFlow<List<PostPreview>?> = _posts

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = getPostUseCase.execute(1, 10)

            _posts.value = posts.data
            Log.e("sady", "Posts ${posts.data}")
        }
    }

}


