package com.ufscar.dirigemais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ufscar.dirigemais.ui.navigation.AppNavigation
import com.ufscar.dirigemais.ui.theme.DirigeMaisTheme

/**
 * MainActivity — único ponto de entrada do app.
 *
 * Em Compose, normalmente temos apenas UMA Activity.
 * A navegação entre "telas" é feita pelo NavHost (NavGraph),
 * que troca Composables dentro desta mesma Activity.
 *
 * Diferente do XML onde cada tela era uma Activity separada,
 * aqui o Android recicla a mesma Activity e apenas muda o que aparece na tela.
 */
class MainActivity : ComponentActivity() {

    // AppContainer criado aqui — 1 instância para todo o app
    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        appContainer = AppContainer(applicationContext)

        setContent {
            DirigeMaisTheme {
                AppNavigation(container = appContainer)
            }
        }
    }
}
