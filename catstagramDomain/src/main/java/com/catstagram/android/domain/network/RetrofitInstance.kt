package com.catstagram.android.domain.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .connectTimeout(995, TimeUnit.SECONDS)
        .readTimeout(995, TimeUnit.SECONDS)
        .writeTimeout(995, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .addInterceptor(
            ApiKeyInterceptor(
                "live_u76WgkmRMT7SbfWUdEWu5sXKwjj4EdCEJXJd5Pz1rHLKgVS5rPGg9iQSU85RRDe3"
            )
        )
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }
}

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("x-api-key", apiKey)
                .build()
        )
    }
}