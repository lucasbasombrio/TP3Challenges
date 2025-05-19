package com.example.challenges.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenges.R
import com.example.challenges.ui.theme.ChallengesTheme

// Define la fuente Poppins
val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco explícito
            .padding(vertical = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center // Centra la imagen dentro del círculo
        ) {
            // Fondo gris (círculo)
            Box(
                modifier = Modifier
                    .size(340.dp)
                    .offset(x = (150.dp), y = (-150.dp)) // Mueve solo el círculo
                    .clip(CircleShape)
                    .background(Color(0xFFE5E7EB), shape = CircleShape)
            )

            // Imagen (SVG desde drawable)
            Image(
                painter = painterResource(id = R.drawable.welcome_image),
                contentDescription = "Illustration",
                modifier = Modifier
                    .size(300.dp) // Tamaño de la imagen
                    .padding(bottom = 0.dp) // Ajusta el padding si es necesario
            )
        }

        // Título
        Text(
            text = "DISCOVER YOUR DREAM JOB HERE",
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF1E3A8A)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Subtítulo
        Text(
            text = "Explore all the existing job roles based on your interest and study major",
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Fila para los botones
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botón "Login"
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A8A))
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }

            // Botón "Register" con borde actualizado
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = ButtonDefaults.outlinedButtonBorder(enabled = true) // Nueva sintaxis
            ) {
                Text(
                    text = "Register",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ChallengesTheme {
        HomeScreen()
    }
}