package com.ufscar.dirigemais.ui.navigation

/**
 * Rotas de navegação do app — apenas as 5 telas necessárias.
 */
sealed class Screen(val route: String) {
    object Splash            : Screen("splash")
    object Login             : Screen("login")
    object Register          : Screen("register")
    object StudentHome       : Screen("student_home")
    object Favorites         : Screen("favorites")

    object InstructorDetail : Screen("instructor_detail/{instructorId}") {
        fun createRoute(id: String) = "instructor_detail/$id"
    }
}
