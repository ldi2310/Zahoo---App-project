package com.example.zahoo.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.zahoo.repository.ShortVideoRepository

@Composable
fun ShortVideoScreen() {
    val repository = remember { ShortVideoRepository() }
    var videos by remember { mutableStateOf<List<ShortVideo>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        repository.getShortVideos { videoList, error ->
            if (videoList != null) {
                videos = videoList
            } else {
                errorMessage = error
            }
        }
    }

    if (errorMessage != null) {
        Text("Error: $errorMessage")
    } else {
        VerticalPager(
            count = videos.size,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            VideoPlayer(video = videos[page])
        }
    }
}