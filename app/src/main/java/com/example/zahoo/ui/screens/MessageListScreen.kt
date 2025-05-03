package com.example.zahoo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class User(val id: Int, val name: String)

@Composable
fun MessageListScreen(onUserSelected: (User) -> Unit) {
    val users = listOf(
        User(1, "Alice"),
        User(2, "Bob"),
        User(3, "Charlie"),
        User(4, "David")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Chats", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { onUserSelected(user) }
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(user.name, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}
