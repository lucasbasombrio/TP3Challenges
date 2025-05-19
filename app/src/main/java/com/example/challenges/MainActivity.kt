package com.example.challenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challenges.ui.home.HomeScreen
import com.example.challenges.ui.login.LoginScreen
import com.example.challenges.ui.register.RegisterScreen
import com.example.challenges.ui.theme.ChallengesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengesTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home", // Pantalla inicial
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(
                                onLoginClick = { navController.navigate("login") },
                                onRegisterClick = { navController.navigate("register") }
                            )
                        }
                        composable("login") {
                            LoginScreen(
                                onHomeClick = { navController.navigate("home") },
                                onRegisterClick = { navController.navigate("register") }
                            )
                        }
                        composable("register") {
                            RegisterScreen(
                                onHomeClick = { navController.navigate("home") },
                                onLoginClick = { navController.navigate("login") }
                            )
                        }
                    }
                }
            }
        }
    }
}