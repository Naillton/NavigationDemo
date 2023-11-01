package com.example.navigationdemo.routes

/**
 * Criando NavRoutes, rotas de navegacao para cada tela, home, welcome, profile.
 * Com a classe selada NavRoutes podemos adcionar telas e dividimos rotas de navegacao.
 */
sealed class NavRoutes(val route: String) {

    object Home: NavRoutes("home")

    object Welcome: NavRoutes("welcome")

    object Profile: NavRoutes("profile")
}