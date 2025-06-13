package com.saydullin.data.server.service.auth

import com.saydullin.domain.model.author.LoginResponse
import com.saydullin.domain.model.author.SignUpResponse
import com.saydullin.domain.model.author.AuthorLogin
import com.saydullin.domain.model.author.AuthorSignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    suspend fun login(@Body author: AuthorLogin): Response<LoginResponse>

    @POST("signUp")
    suspend fun signUp(@Body author: AuthorSignUp): Response<SignUpResponse>

}


