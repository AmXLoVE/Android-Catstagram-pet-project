package com.example.myapplication.presentation.story

import android.graphics.Paint.Align
import com.example.myapplication.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.base.model.Story

@Composable
internal fun StoryScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsv(0f, 0f, 0.12f))
    ) {
        HeaderBlock()

        ImageBlock()

        ReactionBlock()
    }
}

@Composable
fun HeaderBlock() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.photo_icon),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(9.dp)
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            text = "Albertina_0_o",
        )
    }
}

@Composable
fun ImageBlock() {

}

@Composable
fun ReactionBlock() {

}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    StoryScreen(
        onNavigate = {}
    )
}