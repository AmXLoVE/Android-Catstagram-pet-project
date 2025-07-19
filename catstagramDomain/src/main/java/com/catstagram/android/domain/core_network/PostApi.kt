package com.catstagram.android.domain.core_network

import com.catstagram.android.domain.core_story.CatImage
import retrofit2.http.GET
import retrofit2.http.Headers

interface PostApi {
    @Headers("x-api-key: live_u76WgkmRMT7SbfWUdEWu5sXKwjj4EdCEJXJd5Pz1rHLKgVS5rPGg9iQSU85RRDe3")
    @GET("images/search?limit=25")
    suspend fun getRandomCat(): List<CatImage>
}