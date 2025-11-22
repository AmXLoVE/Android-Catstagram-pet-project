package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catstagramdomain.R

@Composable
fun HeaderBlock(){
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

    Spacer(
        modifier = Modifier
            .height(4.dp)
            .background(
                color = Color.hsv(206f, 0.1f, 0.9f),
                shape = RoundedCornerShape(percent = 100)
            )
            .fillMaxWidth()
    )
}