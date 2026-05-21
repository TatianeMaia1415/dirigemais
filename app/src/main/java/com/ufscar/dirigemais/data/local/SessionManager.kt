package com.ufscar.dirigemais.data.local

import android.content.Context
import android.content.SharedPreferences

/**
 * Gerencia a sessão do usuário logado usando SharedPreferences.
 * Usado para dados leves de configuração — exatamente como descrito nas aulas
 * (SharedPreferences para dados simples, Room para dados estruturados).
 */
class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("dirige_session", Context.MODE_PRIVATE)

    fun saveSession(userId: Int, nome: String, email: String, tipo: String, instrutorId: String = "") {
        prefs.edit()
            .putInt("user_id", userId)
            .putString("user_nome", nome)
            .putString("user_email", email)
            .putString("user_tipo", tipo)
            .putString("instrutor_id", instrutorId)
            .apply()
    }

    fun getUserId(): Int   = prefs.getInt("user_id", -1)
    fun getUserNome(): String = prefs.getString("user_nome", "") ?: ""
    fun getUserEmail(): String = prefs.getString("user_email", "") ?: ""
    fun getUserTipo(): String = prefs.getString("user_tipo", "") ?: ""
    fun getInstrutorId(): String = prefs.getString("instrutor_id", "") ?: ""
    fun isLoggedIn(): Boolean = getUserId() != -1

    fun updateInstrutorId(instrutorId: String) {
        prefs.edit().putString("instrutor_id", instrutorId).apply()
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}
