package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.catstagram.android.feature.basescreen.model.BaseScreenUiModel
import com.catstagram.android.feature.common.buttonColorsScheme

@Composable
fun BaseScreenError(
    updateContent: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row {
            Text(
                text = "Не удалось загрузить содержимое",
                fontSize = 16.sp,
                color = Color.Gray,
            )
        }

        SpacerHeight(14.dp)

        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
        ) {

            ElevatedButton(
                modifier = Modifier
                    .dropShadow(
                        shape = RoundedCornerShape(50),
                        shadow = Shadow(
                            radius = 16.dp,
                            color = Color.Gray,
                        )
                    ),
                colors = buttonColorsScheme(),
                onClick = updateContent,
            ) {
                Text(
                    text = "Обновить",
                    fontSize = 16.sp,
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun BaseScreenErrorPreview() {
    BaseScreenError({})
}