package com.saydullin.domain.usecase.auth

import com.saydullin.domain.model.author.AuthorLogin
import com.saydullin.domain.model.author.LoginResponse
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.resource.Resource

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun execute(author: AuthorLogin): Resource<LoginResponse> {
        return authRepository.login(author)
    }

}