package com.example.challenges.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenges.ui.main.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var pushNotificationsEnabled by remember { mutableStateOf(false) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EDEB))
            .padding(16.dp)
    ) {
        Text(
            "Account Settings",
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF5D4037),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        SettingItem("Edit profile", onClick = { /* Acción */ })
        SettingItem("Change password", onClick = { /* Acción */ })

        Text(
            "Push notifications",
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF6D4C41),
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { pushNotificationsEnabled = !pushNotificationsEnabled }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Push notifications",
                tint = Color(0xFF6D4C41),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                "Push notifications",
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color(0xFF6D4C41)
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = pushNotificationsEnabled,
                onCheckedChange = { pushNotificationsEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF6D4C41),
                    checkedTrackColor = Color(0xFFBCAAA4),
                    uncheckedThumbColor = Color(0xFFBCAAA4),
                    uncheckedTrackColor = Color(0xFFD7CCC8)
                )
            )
        }

        Text(
            "Dark mode",
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF6D4C41),
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { darkModeEnabled = !darkModeEnabled }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.DarkMode,
                contentDescription = "Dark mode",
                tint = Color(0xFF6D4C41),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                "Dark mode",
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color(0xFF6D4C41)
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = darkModeEnabled,
                onCheckedChange = { darkModeEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF6D4C41),
                    checkedTrackColor = Color(0xFFBCAAA4),
                    uncheckedThumbColor = Color(0xFFBCAAA4),
                    uncheckedTrackColor = Color(0xFFD7CCC8)
                )
            )
        }

        Text(
            "More",
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color(0xFF6D4C41),
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        SettingItem("About us", onClick = { /* Acción */ })
        SettingItem("Privacy policy", onClick = { /* Acción */ })
        SettingItem("Terms and conditions", onClick = { /* Acción */ })
    }
}

@Composable
fun SettingItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF6D4C41)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "More",
            tint = Color(0xFF6D4C41)
        )
    }
}