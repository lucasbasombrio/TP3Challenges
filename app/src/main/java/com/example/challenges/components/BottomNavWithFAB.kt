package com.example.challenges.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.challenges.R
import com.example.challenges.ui.main.MainViewModel
import com.example.challenges.ui.main.Poppins
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.launch

@Composable
fun BottomNavWithFAB(
    navController: NavController,
    viewModel: MainViewModel,
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()
    val currentRoute by viewModel.currentRoute.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        NavigationBar(
            containerColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .align(Alignment.BottomCenter)
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home", fontFamily = Poppins, color = Color.Black) },
                selected = currentRoute == "home",
                onClick = {
                    navController.navigate("home")
                    viewModel.updateRoute("home")
                },
                modifier = Modifier.weight(1f)
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                label = { Text("Search", fontFamily = Poppins, color = Color.Black) },
                selected = currentRoute == "search",
                onClick = {
                    navController.navigate("search")
                    viewModel.updateRoute("search")
                },
                modifier = Modifier.weight(1f)
            )
            Box(modifier = Modifier.weight(1f))
            NavigationBarItem(
                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                label = { Text("Cart", fontFamily = Poppins, color = Color.Black) },
                selected = currentRoute == "cart",
                onClick = {
                    navController.navigate("cart")
                    viewModel.updateRoute("cart")
                },
                modifier = Modifier.weight(1f)
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile") },
                label = { Text("Profile", fontFamily = Poppins, color = Color.Black) },
                selected = currentRoute == "profile",
                onClick = {
                    navController.navigate("profile")
                    viewModel.updateRoute("profile")
                },
                modifier = Modifier.weight(1f)
            )
        }

        FloatingActionButton(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Floating Action Button clicked!")
                }
            },
            containerColor = Color(0xFF5B3022),
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp)
                .size(70.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.tienda),
                contentDescription = "Tienda",
                tint = Color.White,
                modifier = Modifier.size(300.dp)
            )
        }
    }
}