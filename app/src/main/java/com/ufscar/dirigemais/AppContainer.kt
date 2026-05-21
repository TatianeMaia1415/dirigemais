package com.ufscar.dirigemais

import android.content.Context
import com.ufscar.dirigemais.data.local.AppDatabase
import com.ufscar.dirigemais.data.local.SessionManager
import com.ufscar.dirigemais.data.remote.RetrofitClient
import com.ufscar.dirigemais.data.repository.InstructorRepository
import com.ufscar.dirigemais.data.repository.UserRepository

/**
 * AppContainer = "caixa de dependências" manual.
 *
 * Como não usamos Hilt (injeção de dependência automática), criamos as
 * instâncias aqui e as passamos manualmente para quem precisar.
 *
 * ⚠️ FORA DO MATERIAL: Hilt/Dagger são as ferramentas padrão para DI em Android,
 *    mas não foram cobertos nas aulas. Este container manual cumpre a mesma função.
 */
class AppContainer(context: Context) {

    private val database = AppDatabase.getInstance(context)

    val sessionManager = SessionManager(context)

    val instructorRepository = InstructorRepository(
        apiService  = RetrofitClient.apiService,
        favoriteDao = database.favoriteDao()
    )

    val userRepository = UserRepository(
        userDao = database.userDao()
    )
}
