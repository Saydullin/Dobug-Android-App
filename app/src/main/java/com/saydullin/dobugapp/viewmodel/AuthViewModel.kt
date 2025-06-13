package com.saydullin.dobugapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.dobugapp.model.auth.AuthState
import com.saydullin.domain.model.author.AuthorLogin
import com.saydullin.domain.model.author.AuthorSignUp
import com.saydullin.domain.usecase.auth.LoginUseCase
import com.saydullin.domain.usecase.auth.SignUpUseCase
import com.saydullin.domain.util.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val signUpUseCase: SignUpUseCase,
): ViewModel() {

    private val _error = MutableStateFlow<Resource.Error<Unit>?>(null)
    val error: StateFlow<Resource.Error<Unit>?> = _error

    private val _authState = MutableStateFlow<AuthState?>(null)
    val authState: StateFlow<AuthState?> = _authState

    fun login(author: AuthorLogin) {
        viewModelScope.launch(Dispatchers.IO) {
            _authState.value = AuthState.LOADING
            loginUseCase.execute(author).onError { _error.value = it } ?: return@launch

            _authState.value = AuthState.SUCCESS_LOGIN
        }
    }

    fun signup(author: AuthorSignUp) {
        viewModelScope.launch(Dispatchers.IO) {
            _authState.value = AuthState.LOADING
            signUpUseCase.execute(author).onError { _error.value = it } ?: return@launch

            _authState.value = AuthState.SUCCESS_SIGNUP
        }
    }

}