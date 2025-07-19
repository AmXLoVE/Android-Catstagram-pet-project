package com.catstagram.app.activity

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
import dagger.hilt.android.AndroidEntryPoint
import com.catstagram.android.feature.feature_basescreen.ui.*
import com.catstagram.android.feature.feature_story.ui.*
import com.catstagram.android.feature.feature_profile.ui.*
import com.catstagram.android.domain.core_story.StoryPreview

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
                            navController.navigate("$STORY_SCREEN?${story.user.id}")
                        },
                        onShowProfile = { id ->
                            navController.navigate("$PROFILE_SCREEN?${id}")
                        },
                    )
                }

                composable(
                    route = "$STORY_SCREEN?{id}",
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                    ),
                ) { entry ->
                    val id = entry.arguments?.getInt("id") ?: -1
                    StoryScreen(
                        id = id,
                        onShowProfile = { id ->
                            navController.navigate("$PROFILE_SCREEN?${id}")
                        },
                    )
                }

                composable(
                    route = "$PROFILE_SCREEN?{id}",
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType }
                    )
                ) { entry ->
                    val id = entry.arguments?.getInt("id") ?: -1
                    ProfileScreen(
                        id = id,
                        onNavigate = {navController.navigate("$STORY_SCREEN?${id}")},
                    )
                }
            }
        }
    }
}