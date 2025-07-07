package com.example.myapplication.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.myapplication.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.presentation.profile.ui.ProfileUiState
import com.example.myapplication.presentation.profile.vm.ProfileScreenViewModel

@Composable
fun ProfileScreen(
    id: Int,
    onNavigate: () -> Unit,
    viewModel: ProfileScreenViewModel = hiltViewModel(),
) {
    val profileState by remember { viewModel.uiProfileState }.collectAsState()
    viewModel.loadProfile(id)

    Column(
        modifier = Modifier
            .background(
                color = Color
                    .hsv(
                        0f,
                        0.05f,
                        0.08f
                    )
            )
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.app_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .padding(4.dp)
                .background(
                    Color.hsv(
                        0f,
                        0.05f,
                        0.12f
                    ), shape = RoundedCornerShape(4.dp)
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DrawIcon(viewModel.userHasStory(), profileState)

            Text(text = profileState.name, color = Color.White)
        }
    }
}

@Composable
fun DrawIcon(hasStory: Boolean, profileState: ProfileUiState){
    if(hasStory){
        Box(
            modifier = Modifier
                .size(110.dp)
                .padding(4.dp)
                .border(
                    2.dp, color = Color.hsv(
                        0f,
                        0.05f,
                        0.12f
                    ), shape = RoundedCornerShape(100)
                )
        ) {
            Image(
                painter = painterResource(profileState.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
                    .clip(shape = RoundedCornerShape(100)),
            )
        }
    }
    else{
        Box(
            modifier = Modifier
                .size(110.dp)
                .padding(4.dp),
        ) {
            Image(
                painter = painterResource(profileState.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
                    .clip(shape = RoundedCornerShape(100)),
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(1, onNavigate = {}, )
}