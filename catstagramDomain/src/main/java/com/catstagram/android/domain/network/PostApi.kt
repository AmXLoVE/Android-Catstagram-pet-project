package com.catstagram.android.domain.network

import com.catstagram.android.domain.story.CatImage
import retrofit2.http.GET

interface PostApi {
    @GET("images/search?limit=25")
    suspend fun getRandomCat(): List<CatImage>
}