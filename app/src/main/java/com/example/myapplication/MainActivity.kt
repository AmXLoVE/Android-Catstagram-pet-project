package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.base.BaseScreen
import com.example.myapplication.presentation.base.BaseScreenViewModel
import com.example.myapplication.presentation.story.StoryScreen
import com.example.myapplication.presentation.story.StoryScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Map.entry
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val viewModel = hiltViewModel<BaseScreenViewModel>()
            val baseState by remember { viewModel.uiBaseState }.collectAsState()

            NavHost(
                navController = navController,
                startDestination = BASE_SCREEN,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
            ) {
                composable(route = BASE_SCREEN) {
                    BaseScreen(
                        onWatchAll = {
                            baseState.stories[1] // TODO передать в StoryScreen Story
                            navController.navigate(STORY_SCREEN)
                        },
                        onShowCurrentStory = { story ->
//                            currentStory.value = storyRepository.getCurrentStory(story.name)
                            baseState.stories.find { (name, icon, hasStory) -> name == story.name }
                            navController.navigate("$STORY_SCREEN?name=${story.name}")
                        },
                    )
                }

                composable(
                    route = "$STORY_SCREEN?{name}",
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType },
                    ),
                ) { entry ->
                    val userName = entry.arguments?.getString("name") ?: "Гость"
                    Log.i("asdfasdf", "$userName")
                    StoryScreen(
                        name = userName,
                        onNavigate = { navController.navigate(BASE_SCREEN) },
                    )
                }
            }
        }
    }

    @Inject
    lateinit var storyRepository: StoryRepository

}