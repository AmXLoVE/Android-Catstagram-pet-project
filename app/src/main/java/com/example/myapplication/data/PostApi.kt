package com.example.myapplication.data

import com.example.myapplication.domain.story.model.CatImage
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {
    @Headers("x-api-key: live_u76WgkmRMT7SbfWUdEWu5sXKwjj4EdCEJXJd5Pz1rHLKgVS5rPGg9iQSU85RRDe3")
    @GET("images/search")
    suspend fun getRandomCat(): List<CatImage>
}