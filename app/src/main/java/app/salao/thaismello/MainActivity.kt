package app.salao.thaismello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.salao.thaismello.login.LoginScreen
import app.salao.thaismello.singUp.RegisterScreen
import app.salao.thaismello.ui.theme.ThaisMelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThaisMelloTheme(dynamicColor = false) {
                SalaoApp()
            }
        }
    }
}



