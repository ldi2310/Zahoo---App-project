package com.example.zahoo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val label: String, val icon: ImageVector, val badgeCount: Int)

val navItemList = listOf(
    NavItem("", Icons.Default.Home, 0),
    NavItem("", Icons.Default.PlayArrow, 0),
    NavItem("", Icons.Default.Person, 0),
    NavItem("", Icons.Default.Notifications, 5),
    NavItem("", Icons.Default.Email, 5),
    NavItem("", Icons.Default.Settings, 0),
)
