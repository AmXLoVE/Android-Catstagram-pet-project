package com.example.myapplication.data.base

import android.util.Log
import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.base.model.postList
import com.example.myapplication.domain.story.model.CatImage
import javax.inject.Inject

class PostRepository @Inject constructor() {
    /**
     * Вызывается для ленты новостей для N последних постов
     */
    fun getLastNPost(n: Int): List<Post> {
        if (n >= postList.size)
            return postList
        return postList.subList(0, n)
    }

    /**
     * Вызывается в профиле пользователя, отдает все его посты
     */
    fun getAllUserPosts(id: Int): List<Post> {
        return postList
            .filter { it.user.id == id }
    }

    suspend fun getCatImage(): CatImage {
        return RetrofitInstance.api.getRandomCat().firstOrNull() ?: CatImage("-1", "", 0, 0)
    }
}