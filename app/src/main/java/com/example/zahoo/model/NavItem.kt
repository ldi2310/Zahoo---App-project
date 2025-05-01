package com.example.zahoo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val label: String, val icon: ImageVector, val badgeCount: Int)

val navItemList = listOf(
    NavItem("Home", Icons.Default.Home, 0),
    NavItem("Friends", Icons.Default.Person, 0),
    NavItem("Notifications", Icons.Default.Notifications, 5),
    NavItem("Settings", Icons.Default.Settings, 0),
    NavItem("Profile",Icons.Filled.AccountCircle, 0)
)
