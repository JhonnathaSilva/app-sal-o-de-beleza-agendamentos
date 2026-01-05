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
import app.salao.thaismello.screen.LoginScreen
import app.salao.thaismello.screen.RegisterScreen
import app.salao.thaismello.ui.theme.ThaisMelloTheme

enum class Screen {
    LOGIN,
    REGISTER
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThaisMelloTheme {
                NavigationController()
            }
        }
    }
}

@Composable
fun NavigationController() {
    var currentScreen by remember { mutableStateOf(Screen.LOGIN) }

    when (currentScreen) {
        Screen.LOGIN -> {
            LoginScreen(
                onNavigateToRegister = {
                    currentScreen = Screen.REGISTER
                }
            )
        }
        Screen.REGISTER -> {
            RegisterScreen(
                onCreateAccount = {
                    // TODO: Implementar lógica de criação de conta
                    // Após criar conta, pode navegar para login ou outra tela
                    currentScreen = Screen.LOGIN
                },
                onNavigateToLogin = {
                    currentScreen = Screen.LOGIN
                }
            )
        }
    }
}
