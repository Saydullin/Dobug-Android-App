package com.saydullin.data.server.service.auth

import com.saydullin.data.model.UserSignUp
import com.saydullin.domain.model.main.Content
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {

    @POST("sign-up")
    fun signUp(@Body userSignUp: UserSignUp): Call<Content<Boolean>>

}


