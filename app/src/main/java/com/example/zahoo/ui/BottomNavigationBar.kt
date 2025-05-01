package com.example.zahoo.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import com.example.zahoo.model.navItemList

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    BottomNavigation {
        navItemList.forEachIndexed { index, item ->
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
                onClick = {
                    onTabSelected(index)
                }
            )
        }
    }
}

