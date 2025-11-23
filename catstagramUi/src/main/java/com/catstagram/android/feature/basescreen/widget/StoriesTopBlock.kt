package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catstagramdomain.R

@Composable
fun StoriesTopBlock(
    onWatchAll: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Stories", fontSize = 20.sp)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onWatchAll,
            shape = RoundedCornerShape(30.dp),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.White
            ),
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
}