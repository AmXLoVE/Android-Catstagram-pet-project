package com.example.myapplication.data.base

import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.base.model.postList
import javax.inject.Inject

class PostRepository @Inject constructor(){
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

    /**
     * Вызывается для открытия поста ([com.example.myapplication.domain.base.model.Post]) (пока хз зачем надо)
     */
    fun getCurrentPost(id: Int): Post {
        return postList
            .filter { it.user.id == id }[0]
    }
}