package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catstagramdomain.R

@Composable
fun PostBottomBlock(
    likeCount: Int,
    commCount: Int,
    repCount: Int,
) {
    Row(
        modifier = Modifier
            .padding(6.dp, 12.dp)
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(R.drawable.play_icon),
            contentDescription = ""
        )
        Text(
            text = likeCount.toString(),
            fontSize = 22.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )

        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(R.drawable.play_icon),
            contentDescription = ""
        )
        Text(
            text = commCount.toString(),
            fontSize = 22.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )

        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(R.drawable.play_icon),
            contentDescription = ""
        )
        Text(
            text = repCount.toString(),
            fontSize = 22.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}