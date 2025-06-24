package com.example.myapplication.presentation.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class CatstagramScreens(){
    Base,
    Story,
}

//data class TextModifiers(
//    val modifiers: Modifier =
//        Modifier
//            .fillMaxWidth()
//            .padding(12.dp),
//    val text: String = "",
//    val textFontSize: TextUnit = 20.sp,
//    val textFontStyle: FontStyle = FontStyle.Normal,
//    val color: Color = Color.Black,
//)
//
//private val text: TextModifiers = TextModifiers()

@Composable
internal fun BaseScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        HeaderBlock()

        StoriesBlock()

        NewsFeed()
    }
}

@Composable
fun HeaderBlock() {

    Row(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    0f to Color.hsv(206f, 0.00f, 0.9f),
                    0.5f to Color.hsv(206f, 0.07f, 0.8f),
                    1f to Color.hsv(206f, 0.00f, 0.9f)
                )
            )
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.photo_icon),
                contentDescription = "",
            )
        }
        Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Text(text = "Catstagram", fontSize = 25.sp, color = Color.Black)
        }
        Box {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.photo_icon),
                contentDescription = "",
            )
        }
    }
}

@Composable
fun StoriesBlock() {
    Spacer(
        modifier = Modifier
            .height(4.dp)
            .background(
                color = Color.hsv(206f, 0.1f, 0.9f),
                shape = RoundedCornerShape(percent = 100)
            )
            .fillMaxWidth()
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Stories", fontSize = 20.sp)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier,
            onClick = { },
            shape = CutCornerShape(0.dp),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.White
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.play_icon),
                contentDescription = "",
            )
            Text(
                text = "Watch All",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 6.dp)
    ) {
        Column {
            Icon(
                modifier = Modifier.size(75.dp),
                painter = painterResource(R.drawable.photo_icon),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = "You"
            )
        }

    }

    Spacer(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(3.dp)
            .background(color = Color.hsv(206f, 0.03f, 0.9f))
            .fillMaxWidth()
    )
}

@Composable
fun NewsFeed() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

    }
}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    BaseScreen(

    )
}