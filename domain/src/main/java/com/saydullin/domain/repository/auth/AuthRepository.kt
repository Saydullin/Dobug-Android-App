package com.saydullin.domain.repository.auth

import com.saydullin.domain.model.author.AuthorLogin
import com.saydullin.domain.model.author.AuthorSignUp
import com.saydullin.domain.model.author.LoginResponse
import com.saydullin.domain.model.author.SignUpResponse
import com.saydullin.domain.util.resource.Resource

interface AuthRepository {

    suspend fun login(author: AuthorLogin): Resource<LoginResponse>

    suspend fun signUp(author: AuthorSignUp): Resource<SignUpResponse>

    suspend fun logout(): Resource<Unit>

}