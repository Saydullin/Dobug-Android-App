package com.saydullin.data.server.service.userInfo

import com.saydullin.domain.model.main.Content
import com.saydullin.domain.model.user.FullUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInfoService {

    @GET("userInfo/{id}")
    fun userInfo(@Path("id") id: Long): Call<Content<FullUserInfo>>

}


