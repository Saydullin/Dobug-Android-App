package com.saydullin.data.repository.auth

import com.saydullin.data.datastore.JwtSecurityDataStore
import com.saydullin.data.server.service.auth.AuthService
import com.saydullin.domain.model.author.AuthorLogin
import com.saydullin.domain.model.author.AuthorSignUp
import com.saydullin.domain.model.author.LoginResponse
import com.saydullin.domain.model.author.SignUpResponse
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.resource.Resource
import com.saydullin.domain.util.resource.Status
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val jwtSecurityDataStore: JwtSecurityDataStore,
): AuthRepository {

    override suspend fun login(author: AuthorLogin): Resource<LoginResponse> {
        return Resource.tryWithSuspend(Status.LOGIN) {
            val loginResponse = authService.login(author)
            val body = loginResponse.body()
            val token = body?.token

            if (loginResponse.isSuccessful && token != null) {
                jwtSecurityDataStore.setJwtKey(token)

                body
            } else {
                throw Exception("Login error. Code: ${loginResponse.code()}. Message: ${loginResponse.errorBody()}")
            }
        }
    }

    override suspend fun signUp(author: AuthorSignUp): Resource<SignUpResponse> {
        return Resource.tryWithSuspend(Status.SIGNUP) {
            val signUpResponse = authService.signUp(author)
            val body = signUpResponse.body()
            val token = body?.token

            if (signUpResponse.isSuccessful && token != null) {
                jwtSecurityDataStore.setJwtKey(token)

                body
            } else {
                throw Exception("SignUp error. Code: ${signUpResponse.code()}. Message: ${signUpResponse.errorBody()}")
            }
        }
    }

    override suspend fun logout(): Resource<Unit> {
        return Resource.tryWithSuspend(Status.LOGOUT) {
            jwtSecurityDataStore.setJwtKey("")
        }
    }

}


