import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenges.ui.theme.ChallengesTheme

@Preview(
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Primer Preview")
@Composable
fun AppHolaMundo(){
    ChallengesTheme {
        AppHolaMundoScaffold()
    }
}

@Composable
fun AppHolaMundoScaffold(){
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { } ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){ innerPadding ->
        Text(
            text = "Hello World!"
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Click mee!")
        }

    }
}

@Preview(
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Otra pantalla")
@Composable
fun hola(){
    Text(
        text = "Hola mundo",
        modifier = Modifier
            .padding(16.dp)
    )
}


@Composable
fun ButtonGeneric(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ){
        Text(text = text)
    }
}
@Preview(
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Boton generic")
@Composable
fun PreviewGenericButtom(){
    ButtonGeneric("Login", onClick = {/*TODO*/})
}