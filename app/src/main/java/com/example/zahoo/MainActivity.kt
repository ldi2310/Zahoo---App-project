package com.example.zahoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.zahoo.ui.ZahooUI
import com.example.zahoo.ui.screens.SignInScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }

    @Composable
    fun AppNavigation() {
        var isSignedIn by remember { mutableStateOf(false) } // Track sign-in state

        if (isSignedIn) {
            // Show Zahoo UI after successful sign-in
            ZahooUI()
        } else {
            // Show SignInScreen if not signed in
            SignInScreen(
                onSignIn = { username, password ->
                    // Xử lý đăng nhập nếu cần
                },
                onSignInSuccess = { isSignedIn = true } // Set lại trạng thái khi đăng nhập thành công
            )
        }
    }
}
