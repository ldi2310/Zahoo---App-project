package com.example.zahoo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen(onBack: () -> Unit) {
    var query by remember { mutableStateOf("") }

    val allItems = listOf(
        "John Doe", "Jane Smith", "Zahoo Team", "Flutter Group",
        "Android Devs", "Kotlin Learners", "Compose Community",
        "React Fans", "Jetpack Experts", "UI/UX Designers"
    )

    val filteredItems = allItems.filter {
        it.contains(query, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Thanh công cụ: Trở về và Tìm kiếm
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.size(44.dp) // Tăng kích thước tổng thể nút
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Trở về",
                    modifier = Modifier.size(28.dp) // Tăng kích thước biểu tượng
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = { Text("Tìm kiếm...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { query = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Xóa")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                singleLine = true
            )
        }

        if (query.isEmpty()) {
            Text(
                text = "Nhập để bắt đầu tìm kiếm...",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        } else {
            Text(
                text = "Kết quả (${filteredItems.size}):",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(filteredItems) { item ->
                    SearchResultItem(name = item)
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1))
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true, name = "SearchScreen Preview")
@Composable
fun PreviewSearchScreen() {
    SearchScreen(onBack = {})
}
