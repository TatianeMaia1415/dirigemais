package com.ufscar.dirigemais.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Entity → diz ao Room que essa classe representa uma tabela no banco SQLite.
 * tableName → nome da tabela no banco.
 * @PrimaryKey → coluna que identifica cada linha unicamente.
 *
 * FavoriteEntity: armazena os instrutores salvos como favoritos (R4: Room)
 */
@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val instructorId: String,     // ID do instrutor na API
    val nome: String,
    val foto: String,
    val cidade: String,
    val bairro: String,
    val preco: Double,
    val nota: Double,
    val totalAvaliacoes: Int,
    val telefone: String
)

/**
 * UserEntity: armazena os usuários cadastrados localmente.
 * Usamos Room aqui porque é mais simples que uma API de autenticação real.
 * (O professor permitiu simular o back-end conforme o documento de requisitos)
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    val senha: String,    // Em produção real, nunca armazene senha em plain text!
    val nome: String,
    val tipo: String,     // "aluno" ou "instrutor"
    val instrutorId: String = "" // ID do perfil de instrutor na API (se tipo == "instrutor")
)
