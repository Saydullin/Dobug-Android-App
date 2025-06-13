package com.saydullin.domain.usecase.auth

import com.saydullin.domain.model.author.AuthorSignUp
import com.saydullin.domain.model.author.SignUpResponse
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.resource.Resource

class SignUpUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun execute(author: AuthorSignUp): Resource<SignUpResponse> {
        return authRepository.signUp(author)
    }

}


