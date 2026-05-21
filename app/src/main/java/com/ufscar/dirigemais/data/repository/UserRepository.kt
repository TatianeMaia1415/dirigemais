package com.ufscar.dirigemais.data.repository

import com.ufscar.dirigemais.data.local.dao.UserDao
import com.ufscar.dirigemais.data.local.entity.UserEntity

/**
 * Repository responsável por autenticação local.
 * O login é verificado contra o banco Room (sem servidor de autenticação real).
 * Conforme permitido pelo professor: "o back-end pode ser apenas simulado".
 */
class UserRepository(private val userDao: UserDao) {

    /** Retorna true se o e-mail já está cadastrado */
    suspend fun emailExists(email: String): Boolean =
        userDao.getUserByEmail(email) != null

    /** Cadastra novo usuário. Retorna o ID gerado ou -1 se falhou. */
    suspend fun register(nome: String, email: String, senha: String, tipo: String): Long {
        val user = UserEntity(nome = nome, email = email, senha = senha, tipo = tipo)
        return try {
            userDao.insertUser(user)
        } catch (e: Exception) {
            -1L
        }
    }

    /** Verifica credenciais e retorna o UserEntity se válido, null se inválido */
    suspend fun login(email: String, senha: String): UserEntity? =
        userDao.getUserByCredentials(email, senha)

    /** Atualiza o ID do perfil de instrutor após criar perfil na API */
    suspend fun updateInstrutorId(email: String, instrutorId: String) {
        userDao.updateInstructorId(email, instrutorId)
    }
}
