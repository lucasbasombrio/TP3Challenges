package com.example.challenges.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.challenges.components.BottomNavWithFAB
import com.example.challenges.components.TopAppBarComponent
import com.example.challenges.ui.main.Poppins
import com.example.challenges.ui.theme.ChallengesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()
    val currentRoute by viewModel.currentRoute.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentTitle = when (navBackStackEntry?.destination?.route) {
        "home" -> "Home"
        "search" -> "Search"
        "cart" -> "Cart"
        "profile" -> "Profile"
        "settings" -> "Settings"
        else -> "Home"
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
                NavigationDrawerItem(
                    label = { Text("Home", fontFamily = Poppins, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("home")
                        viewModel.updateRoute("home")
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Search", fontFamily = Poppins, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    selected = currentRoute == "search",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("search")
                        viewModel.updateRoute("search")
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Cart", fontFamily = Poppins, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                    selected = currentRoute == "cart",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("cart")
                        viewModel.updateRoute("cart")
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Profile", fontFamily = Poppins, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("profile")
                        viewModel.updateRoute("profile")
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Settings", fontFamily = Poppins, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    selected = currentRoute == "settings",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("settings")
                        viewModel.updateRoute("settings")
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarComponent(
                    navController = navController,
                    viewModel = viewModel,
                    drawerState = drawerState,
                    title = currentTitle
                )
            },
            bottomBar = {
                BottomNavWithFAB(
                    navController = navController,
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState
                )
            },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFFFF3E0)) // Fondo naranja muy clarito
            ) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // Contenido de la pantalla Home (vacío por ahora)
                        }
                    }
                    composable("search") {
                        Text(
                            "Search Screen",
                            modifier = Modifier.align(Alignment.Center),
                            fontFamily = Poppins
                        )
                    }
                    composable("cart") {
                        Text(
                            "Cart Screen",
                            modifier = Modifier.align(Alignment.Center),
                            fontFamily = Poppins
                        )
                    }
                    composable("profile") {
                        Text(
                            "Profile Screen",
                            modifier = Modifier.align(Alignment.Center),
                            fontFamily = Poppins
                        )
                    }
                    composable("settings") {
                        SettingsScreen()
                    }
                }
            }
        }
    }
}