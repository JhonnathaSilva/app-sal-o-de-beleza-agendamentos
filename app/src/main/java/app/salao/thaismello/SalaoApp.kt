package app.salao.thaismello

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.salao.thaismello.login.LoginScreen
import app.salao.thaismello.singUp.RegisterScreen

@Composable
fun SalaoApp() {
    val navController = rememberNavController()
    SalaoAppNavHost(navController = navController)

}

@Composable
fun SalaoAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.LOGIN.route) {
        composable(Screens.LOGIN.route) {
            LoginScreen(
                onNavigationToHome = {navController.navigate(Screens.USER_SCREEN.route) }
                ) {
                navController.navigate(Screens.REGISTER.route)
            }
        }
        composable (Screens.REGISTER.route){
            RegisterScreen {navController.navigate(Screens.LOGIN.route)}
        }
    }

}

