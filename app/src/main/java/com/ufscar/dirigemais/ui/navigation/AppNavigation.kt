package com.ufscar.dirigemais.ui.navigation

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.ufscar.dirigemais.AppContainer
import com.ufscar.dirigemais.ui.screens.auth.*
import com.ufscar.dirigemais.ui.screens.splash.SplashScreen
import com.ufscar.dirigemais.ui.screens.student.detail.InstructorDetailScreen
import com.ufscar.dirigemais.ui.screens.student.detail.InstructorDetailViewModel
import com.ufscar.dirigemais.ui.screens.student.favorites.FavoritesScreen
import com.ufscar.dirigemais.ui.screens.student.favorites.FavoritesViewModel
import com.ufscar.dirigemais.ui.screens.student.home.HomeScreen
import com.ufscar.dirigemais.ui.screens.student.home.HomeViewModel


@Composable
fun AppNavigation(container: AppContainer) {
    val navController = rememberNavController()
    val session       = container.sessionManager

    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModel.Factory(container.userRepository, container.sessionManager)
    )

    NavHost(
        navController    = navController,
        startDestination = Screen.Splash.route
    ) {

        // ── Tela 1: Splash ──────────────────────────────────────────
        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = { _, _ ->
                    val dest = if (session.isLoggedIn()) Screen.StudentHome.route
                               else                     Screen.Login.route
                    navController.navigate(dest) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // ── Tela 2a: Login ──────────────────────────────────────────
        composable(Screen.Login.route) {
            LoginScreen(
                viewModel            = authViewModel,
                onLoginSuccess       = { _ ->
                    navController.navigate(Screen.StudentHome.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = { navController.navigate(Screen.Register.route) }
            )
        }

        // ── Tela 2b: Cadastro ────────────────────────────────────────
        composable(Screen.Register.route) {
            RegisterScreen(
                viewModel         = authViewModel,
                onRegisterSuccess = { _ ->
                    navController.navigate(Screen.StudentHome.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateBack    = { navController.popBackStack() }
            )
        }

        // ── Tela 3: Home do Aluno ────────────────────────────────────
        composable(Screen.StudentHome.route) {
            val vm: HomeViewModel = viewModel(
                factory = HomeViewModel.Factory(container.instructorRepository)
            )
            HomeScreen(
                viewModel         = vm,
                userName          = session.getUserNome(),
                onInstructorClick = { id ->
                    if (id.isNotBlank()) {
                        navController.navigate(Screen.InstructorDetail.createRoute(id))
                    }
                },
                onFavoritesClick  = { navController.navigate(Screen.Favorites.route) },
                onSettingsClick   = {
                    // logout direto do ícone de perfil
                    session.logout()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        // ── Tela 4: Detalhes do Instrutor ────────────────────────────
        composable(
            route     = Screen.InstructorDetail.route,
            arguments = listOf(navArgument("instructorId") { type = NavType.StringType })
        ) { backStack ->
            val id = backStack.arguments?.getString("instructorId") ?: return@composable
            val vm: InstructorDetailViewModel = viewModel(
                factory = InstructorDetailViewModel.Factory(container.instructorRepository)
            )
            InstructorDetailScreen(
                instructorId   = id,
                viewModel      = vm,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // ── Tela 5: Favoritos ─────────────────────────────────────────
        composable(Screen.Favorites.route) {
            val vm: FavoritesViewModel = viewModel(
                factory = FavoritesViewModel.Factory(container.instructorRepository)
            )
            FavoritesScreen(
                viewModel         = vm,
                onInstructorClick = { id ->
                    navController.navigate(Screen.InstructorDetail.createRoute(id))
                },
                onNavigateBack    = { navController.popBackStack() }
            )
        }
    }
}
