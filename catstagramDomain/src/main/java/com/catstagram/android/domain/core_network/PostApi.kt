package com.catstagram.android.domain.core_network

import com.catstagram.android.domain.core_story.CatImage
import retrofit2.http.GET
import retrofit2.http.Headers

interface PostApi {
    @GET("images/search?limit=25")
    suspend fun getRandomCat(): List<CatImage>
}