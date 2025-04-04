package com.example.zahoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZahooUI()
        }
    }
}

// Data class for navigation items
data class NavItem(val label: String, val icon: ImageVector, val badgeCount: Int)

val navItemList = listOf(
    NavItem("Home", Icons.Default.Home, 0),
    NavItem("Friends", Icons.Default.Person, 0),
    NavItem("Notifications", Icons.Default.Notifications, 5),
    NavItem("Settings", Icons.Default.Settings, 0),
)

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
                0 -> HomeScreen()
                1 -> FriendsScreen()
                2 -> NotificationsScreen()
                3 -> SettingsScreen()
            }
        }
    }
}

@Composable
fun TopNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Zahoo", fontSize = 30.sp, color = Color.Blue)
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    BottomNavigation {
        navItemList.forEachIndexed { index, item ->
            Modifier
                .layout(bottom).dp)
            BottomNavigationItem(
                icon = {
                    if (item.badgeCount > 0) {
                        BadgedBox(badge = {
                            Badge { Text("${item.badgeCount}") }
                        }) {
                            Icon(item.icon, contentDescription = item.label)
                        }
                    } else {
                        Icon(item.icon, contentDescription = item.label)
                    }
                },
                label = { Text(item.label) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}

@Composable
fun HomeScreen() {
    var postText by remember { mutableStateOf(TextFieldValue()) }
    val posts = remember { mutableStateListOf("Chào mừng bạn đến với Zahoo!", "Test bài viết....") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                        posts.add(0, postText.text)
                        postText = TextFieldValue()
                    }
                },
                enabled = postText.text.isNotBlank()
            ) {
                Text("Đăng")
            }
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        LazyColumn {
            items(posts) { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Text(post, modifier = Modifier.padding(16.dp), fontSize = 18.sp)
                }
            }
        }
    }
}

@Composable
fun FriendsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Friends Screen", fontSize = 24.sp)
    }
}

@Composable
fun NotificationsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Notifications Screen", fontSize = 24.sp)
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen", fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUI() {
    ZahooUI()
}
