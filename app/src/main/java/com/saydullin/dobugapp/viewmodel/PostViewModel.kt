package com.saydullin.dobugapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.usecase.post.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
): ViewModel() {

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = getPostUseCase.execute(1, 10)
            Log.e("sady", "Posts ${posts.data}")
        }
    }

}


