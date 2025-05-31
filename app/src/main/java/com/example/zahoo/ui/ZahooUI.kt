package com.example.zahoo.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zahoo.ui.components.BottomNavigationBar
import com.example.zahoo.ui.components.TopNavBar
import com.example.zahoo.ui.screens.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ZahooUI() {
    val navController = rememberAnimatedNavController()
    val animationDuration = 200 // chỉnh delay tại đây (ms)

    AnimatedNavHost(
        navController = navController,
        startDestination = "main",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = animationDuration)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(durationMillis = animationDuration)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(durationMillis = animationDuration)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = animationDuration)
            )
        }
    ) {
        composable("main") {
            var selectedTab by remember { mutableStateOf(0) }

            Scaffold(
                topBar = { TopNavBar(navController) },
                bottomBar = { BottomNavigationBar(selectedTab) { selectedTab = it } }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    when (selectedTab) {
                        0 -> HomeScreen(onSignIn = {}, onLogOut = {})
                        2 -> FriendsScreen()
                        3 -> NotificationsScreen()
                        4 -> {
                            var selectedUser by remember { mutableStateOf<User?>(null) }
                            if (selectedUser == null) {
                                MessageListScreen { user -> selectedUser = user }
                            } else {
                                ChatScreen(user = selectedUser!!) { selectedUser = null }
                            }
                        }
                        5 -> ProfileScreen(
                            name = "John Doe",
                            email = "johndoe@example.com",
                            postsCount = "12",
                            followersCount = "620",
                            followingCount = "197",
                            onEditProfileClick = {}
                        )
                        else -> Text("Page not found", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }

        composable("search_screen") {
            SearchScreen(onBack = { navController.popBackStack() })
        }
    }
}
