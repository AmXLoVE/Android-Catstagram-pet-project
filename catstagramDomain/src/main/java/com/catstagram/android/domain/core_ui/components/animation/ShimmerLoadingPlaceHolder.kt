package com.catstagram.android.domain.core_ui.components.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.shimmerLoading(
    durationMillis: Int = 2000,
    isLoading: Boolean,
): Modifier {
    if (isLoading) {
        val transition = rememberInfiniteTransition(label = "")

        val translateAnimation by transition.animateFloat(
            initialValue = 500f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart,
            ),
            label = "",
        )

        return drawBehind {
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.LightGray.copy(alpha = 0.2f),
                        Color.LightGray.copy(alpha = 1f),
                        Color.LightGray.copy(alpha = 0.2f),
                    ),
                    start = Offset(x = translateAnimation - 1500f, y = translateAnimation - 1500f),
                    end = Offset(x = translateAnimation + 1500f, y = translateAnimation + 1500f),
                )
            )
        }
    }
    return this
}