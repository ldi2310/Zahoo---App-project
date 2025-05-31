package com.example.zahoo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zahoo.ui.components.BottomNavigationBar
import com.example.zahoo.ui.components.TopNavBar
import com.example.zahoo.ui.screens.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZahooUI() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopNavBar() },
        bottomBar = { BottomNavigationBar(selectedTab) { selectedTab = it } }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> HomeScreen(
                    onSignIn = { /* Add navigation or logic for Sign In */ },
                    onLogOut = { /* Add navigation or logic for Log Out */ }
                )
                1 -> ShortVideoScreen() // Thêm màn hình ShortVideo
                2 -> FriendsScreen()
                3 -> NotificationsScreen()
                4 -> {
                    var selectedUser by remember { mutableStateOf<User?>(null) }

                    if (selectedUser == null) {
                        MessageListScreen(onUserSelected = { user ->
                            selectedUser = user
                        })
                    } else {
                        ChatScreen(user = selectedUser!!, onBack = {
                            selectedUser = null
                        })
                    }
                }
                5 -> ProfileScreen(
                    name = "John Doe",
                    email = "johndoe@example.com",
                    postsCount = "12",
                    followersCount = "620",
                    followingCount = "197",
                    onEditProfileClick = { /* Add navigation or logic for Edit Profile */ }
                )
                else -> {
                    Text("Page not found", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}