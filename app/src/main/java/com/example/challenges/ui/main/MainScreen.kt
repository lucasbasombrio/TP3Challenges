package com.example.challenges.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challenges.ui.theme.ChallengesTheme
import com.example.challenges.ui.main.Poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()
    val inputText by viewModel.inputText.collectAsState()
    val currentRoute by viewModel.currentRoute.collectAsState()

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
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("TITLE", fontFamily = Poppins, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate("profile")
                            viewModel.updateRoute("profile")
                        }) {
                            Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = Color.DarkGray
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home", fontFamily = Poppins, color = Color.White) },
                        selected = currentRoute == "home",
                        onClick = {
                            navController.navigate("home")
                            viewModel.updateRoute("home")
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                        label = { Text("Search", fontFamily = Poppins, color = Color.White) },
                        selected = currentRoute == "search",
                        onClick = {
                            navController.navigate("search")
                            viewModel.updateRoute("search")
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                        label = { Text("Cart", fontFamily = Poppins, color = Color.White) },
                        selected = currentRoute == "cart",
                        onClick = {
                            navController.navigate("cart")
                            viewModel.updateRoute("cart")
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile") },
                        label = { Text("Profile", fontFamily = Poppins, color = Color.White) },
                        selected = currentRoute == "profile",
                        onClick = {
                            navController.navigate("profile")
                            viewModel.updateRoute("profile")
                        }
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Floating Action Button clicked!")
                        }
                    },
                    containerColor = Color(0xFF9C27B0)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
                }
            },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
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
                }
            }
        }
    }
}