package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.presentation.base.BaseScreen
import com.example.myapplication.presentation.story.StoryScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = BASE_SCREEN,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
            ) {
                composable(route = BASE_SCREEN) {
                    BaseScreen(
                        onWatchAll = {
                            navController.navigate("$STORY_SCREEN?0")
                        },
                        onShowCurrentStory = { story ->
                            navController.navigate("$STORY_SCREEN?${story.name}")
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
                    StoryScreen(
                        name = userName,
                        onNavigate = { navController.navigate(BASE_SCREEN) },
                    )
                }
            }
        }
    }
}