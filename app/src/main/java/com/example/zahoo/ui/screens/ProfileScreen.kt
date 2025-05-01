package com.example.zahoo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zahoo.R // Ensure this resource exists in your project

@Composable
fun ProfileScreen(
    name: String = "John Doe",  // Default name for testing
    email: String = "johndoe@example.com",  // Default email for testing
    postsCount: String = "12",  // Default post count for testing
    followersCount: String = "620",  // Default follower count for testing
    followingCount: String = "197",  // Default following count for testing
    onEditProfileClick: () -> Unit = {},  // Default empty click handler
    showEditButton: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_account_circle_24), // Ensure this drawable exists
            contentDescription = "$name's Profile Image",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Name & Email
        Text(
            text = name,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Stats in Card
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileStat(title = "Posts", count = postsCount)
                ProfileStat(title = "Followers", count = followersCount)
                ProfileStat(title = "Following", count = followingCount)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Action button (optional)
        if (showEditButton) {
            Button(
                onClick = onEditProfileClick,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Edit Profile", color = Color.White)
            }
        }
    }
}

@Composable
fun ProfileStat(title: String, count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = title, color = Color.Gray, fontSize = 14.sp)
    }
}