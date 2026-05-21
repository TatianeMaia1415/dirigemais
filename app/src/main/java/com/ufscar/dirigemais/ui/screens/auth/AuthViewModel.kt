package com.ufscar.dirigemais.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ufscar.dirigemais.data.local.SessionManager
import com.ufscar.dirigemais.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel de autenticação.
 *
 * ViewModel: sobrevive a mudanças de configuração (rotação da tela).
 * Nunca referencia Activity ou Context diretamente — evita memory leak.
 *
 * StateFlow: versão moderna do LiveData, mais integrada com Compose.
 * ⚠️ FORA DO MATERIAL: StateFlow (o material usa LiveData com Observers)
 *    Aqui usamos StateFlow porque é o padrão recomendado para Compose.
 */
class AuthViewModel(
    private val userRepository: UserRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    sealed class AuthState {
        object Idle    : AuthState()
        object Loading : AuthState()
        data class LoginSuccess(val tipo: String) : AuthState()
        data class RegisterSuccess(val tipo: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun login(email: String, senha: String, tipoEscolhido: String = "aluno") {
        if (email.isBlank() || senha.isBlank()) {
            _authState.value = AuthState.Error("Preencha todos os campos")
            return
        }
        viewModelScope.launch {   // coroutine no escopo da ViewModel
            _authState.value = AuthState.Loading
            val user = userRepository.login(email.trim(), senha)
            if (user != null) {
                // Valida se o tipo bate com o cadastro
                if (user.tipo != tipoEscolhido) {
                    _authState.value = AuthState.Error("Perfil não encontrado para este tipo de usuário")
                    return@launch
                }
                sessionManager.saveSession(
                    userId      = user.id,
                    nome        = user.nome,
                    email       = user.email,
                    tipo        = user.tipo,
                    instrutorId = user.instrutorId
                )
                _authState.value = AuthState.LoginSuccess(user.tipo)
            } else {
                _authState.value = AuthState.Error("E-mail ou senha incorretos")
            }
        }
    }

    fun register(nome: String, email: String, senha: String, tipo: String) {
        if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
            _authState.value = AuthState.Error("Preencha todos os campos")
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _authState.value = AuthState.Error("E-mail inválido")
            return
        }
        if (senha.length < 6) {
            _authState.value = AuthState.Error("Senha deve ter ao menos 6 caracteres")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            if (userRepository.emailExists(email.trim())) {
                _authState.value = AuthState.Error("Este e-mail já está cadastrado")
                return@launch
            }
            val id = userRepository.register(nome.trim(), email.trim(), senha, tipo)
            if (id > 0) {
                sessionManager.saveSession(
                    userId = id.toInt(), nome = nome.trim(), email = email.trim(), tipo = tipo
                )
                _authState.value = AuthState.RegisterSuccess(tipo)
            } else {
                _authState.value = AuthState.Error("Erro ao criar conta. Tente novamente.")
            }
        }
    }

    fun resetState() { _authState.value = AuthState.Idle }

    /** Factory necessária para passar dependências ao ViewModel sem Hilt */
    class Factory(
        private val repo: UserRepository,
        private val session: SessionManager
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            AuthViewModel(repo, session) as T
    }
}
