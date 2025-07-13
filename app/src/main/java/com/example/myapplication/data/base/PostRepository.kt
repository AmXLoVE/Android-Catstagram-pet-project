package com.example.myapplication.data.base

import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.story.model.CatImage
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor() {
    var cachedPosts: List<Post>? = null
    private var loadingJob: Deferred<List<Post>>? = null
    private val mutex = Mutex()

    suspend fun getPosts(): List<Post> {
        cachedPosts?.let { return it }

        return mutex.withLock {
            cachedPosts?.let { return it }

            if (loadingJob == null) {
                loadingJob = CoroutineScope(Dispatchers.IO).async {
                    buildPostList()
                }
            }

            val result = loadingJob!!.await()
            cachedPosts = result
            return result
        }
    }

    private suspend fun buildPostList(): List<Post> {
        return listOf(
            buildPost(userList[0]),
            buildPost(userList[0]),
            buildPost(userList[0]),
            buildPost(userList[0]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[1]),
            buildPost(userList[2]),
            buildPost(userList[2]),
            buildPost(userList[2]),
            buildPost(userList[2]),
            buildPost(userList[2]),
            buildPost(userList[3]),
            buildPost(userList[3]),
            buildPost(userList[3]),
            buildPost(userList[4]),
            buildPost(userList[4]),
            buildPost(userList[4]),
            buildPost(userList[5]),
            buildPost(userList[5]),
            buildPost(userList[6]),
        )
    }

    private suspend fun buildPost(user: User): Post {
        val image = getCatImage()
        return Post(
            user = user,
            image = image.url,
            width = image.width,
            height = image.height,
        )

    }

    fun getLastNPost(n: Int): List<Post> {
        return runBlocking { getPosts() }.take(n)
    }

    fun getAllUserPosts(id: Int): List<Post> {
        return runBlocking { getPosts() }.filter { it.user.id == id }
    }

    suspend fun getCatImage(): CatImage {
        return RetrofitInstance.api.getRandomCat().firstOrNull() ?: CatImage("-1", "", 0, 0)
    }
}



