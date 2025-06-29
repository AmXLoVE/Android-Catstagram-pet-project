package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.base.BaseScreen
import com.example.myapplication.presentation.story.model.Story
import com.example.myapplication.presentation.story.model.storyList
import com.example.myapplication.presentation.story.StoryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val currentStory = remember { mutableStateOf<Story?>(null) } //TODO ViewModel

            NavHost(
                navController = navController,
                startDestination = BASE_SCREEN,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
            ) {
                composable(route = BASE_SCREEN) {
                    BaseScreen(
                        onWatchAll = {
                            currentStory.value = if (storyList.size > 1) storyList[1] else null
                            navController.navigate(STORY_SCREEN)
                        },
                        onShowCurrentStory = { story ->
                            currentStory.value = story
                            navController.navigate(STORY_SCREEN)
                        },
                    )
                }

                composable(STORY_SCREEN) {
                    StoryScreen(
                        onNavigate = { navController.navigate(BASE_SCREEN) },
                        story = currentStory.value,
                    )
                }
            }
        }
    }
}

const val STORY_SCREEN = "StoryScreen"
const val BASE_SCREEN = "BaseScreen"
