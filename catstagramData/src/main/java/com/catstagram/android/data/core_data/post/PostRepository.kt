package com.catstagram.android.data.core_data.post

import com.catstagram.android.domain.network.RetrofitInstance
import com.catstagram.android.domain.post.Post
import com.catstagram.android.domain.story.CatImage
import com.catstagram.android.domain.user.User
import com.catstagram.android.domain.user.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.filter
import kotlin.collections.isNotEmpty
import kotlin.collections.take

@Singleton
class PostRepository @Inject constructor() {
    var cachedPosts: List<Post>? = null
    private var loadingJob: Deferred<List<Post>>? = null
    private val imageQueue: ArrayDeque<CatImage> = ArrayDeque()

    suspend fun getPosts(): List<Post> {
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

    private suspend fun buildPostList(): List<Post> {
        getCatImages()
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
        if (imageQueue.isNotEmpty())
            return imageQueue.removeFirst()
        return CatImage("-1", "", 0, 0)
    }

    suspend fun getCatImages() {
        imageQueue.addAll(RetrofitInstance.api.getRandomCat())
    }
}