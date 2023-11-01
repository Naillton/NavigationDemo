package com.example.navigationdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdemo.routes.NavRoutes
import com.example.navigationdemo.screens.HomeScreen
import com.example.navigationdemo.screens.ProfileScreen
import com.example.navigationdemo.screens.WelcomeScreen
import com.example.navigationdemo.ui.theme.NavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * Usando MainScreen e criando navController passando as rotas de navegacao e definindo NavHost
 */

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
        ){

        composable(NavRoutes.Home.route) {
            HomeScreen().Home(navController = navController)
        }
        // passando o userName como argumento e acessando o argumento passado para a rota
        composable(NavRoutes.Welcome.route + "/{userName}") {backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            WelcomeScreen().Welcome(navController = navController, userName!!)
        }

        composable(NavRoutes.Profile.route) {
            ProfileScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationDemoTheme {
        MainScreen()
    }
}