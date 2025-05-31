@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zahoo.ui.screens

import androidx.compose.material3.DismissState
import androidx.compose.material3.rememberDismissState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.DismissValue

@Composable
fun NotificationsScreen() {
    var notifications by remember {
        mutableStateOf(
            listOf(
                "Alice liked your post",
                "Bob commented on your photo",
                "Charlie sent you a friend request",
                "David mentioned you in a comment",
                "Eve started following you"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notifications",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF4F78D0),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                top = paddingValues.calculateTopPadding(),
                end = 16.dp,
                bottom = paddingValues.calculateBottomPadding()
            ),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE8F1FF)),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notifications) { notification ->
                SwipeToDeleteCard(
                    text = notification,
                    onDelete = {
                        notifications = notifications - notification
                    }
                )
            }
        }
    }
}

@Composable
fun SwipeToDeleteCard(
    text: String,
    onDelete: () -> Unit
) {
    val dismissState = rememberDismissState(
        confirmValueChange = { dismissValue ->
            if (dismissValue == DismissValue.DismissedToEnd || dismissValue == DismissValue.DismissedToStart) {
                onDelete()
                true
            } else {
                false
            }
        }
    )

    SwipeToDismiss(
        state = dismissState,
        background = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF4F78D0)), // Blue background for delete action
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Delete",
                    color = Color.White, // Thay đổi để hiển thị chữ "Delete" rõ ràng hơn
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        },
        dismissContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = text,
                        fontSize = 16.sp,
                        color = Color(0xFF333333),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    )
}