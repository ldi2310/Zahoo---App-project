package com.example.zahoo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun HomeScreen(onSignIn: () -> Unit, onLogOut: () -> Unit) {
    var postText by remember { mutableStateOf(TextFieldValue()) }
    val posts = remember {
        mutableStateListOf(
            Pair("Chào mừng bạn đến với Zahoo!", "https://via.placeholder.com/300"),
            Pair("Bài viết có ảnh demo", "https://via.placeholder.com/400")
        )
    }

    var isMenuExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { isMenuExpanded = !isMenuExpanded }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "User Menu")
            }

            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    isMenuExpanded = false
                    onSignIn()
                }) {
                    Text("Sign In")
                }
                DropdownMenuItem(onClick = {
                    isMenuExpanded = false
                    onLogOut()
                }) {
                    Text("Log Out")
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Avatar",
                tint = Color.Blue,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )

            BasicTextField(
                value = postText,
                onValueChange = { postText = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )

            Button(
                onClick = {
                    if (postText.text.isNotEmpty()) {
                        posts.add(0, Pair(postText.text, "https://via.placeholder.com/350"))
                        postText = TextFieldValue()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                enabled = postText.text.isNotBlank()
            ) {
                Text("Đăng", color = Color.White)
            }
        }

        LazyColumn {
            items(posts) { (text, imageUrl) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    backgroundColor = Color(0xFFE3F2FD),
                    elevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Avatar",
                                tint = Color.Blue,
                                modifier = Modifier
                                    .size(36.dp)
                                    .padding(end = 8.dp)
                            )
                            Text("Người dùng", fontSize = 16.sp, color = Color(0xFF1976D2))
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text, fontSize = 16.sp)

                        Spacer(modifier = Modifier.height(8.dp))
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = "Post image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                    }
                }
            }
        }
    }
}