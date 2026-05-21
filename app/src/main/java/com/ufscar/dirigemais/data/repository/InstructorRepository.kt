package com.ufscar.dirigemais.data.repository

import com.ufscar.dirigemais.data.local.dao.FavoriteDao
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.remote.ApiService
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.*
import kotlinx.coroutines.flow.Flow


class InstructorRepository(
    private val apiService: ApiService,
    private val favoriteDao: FavoriteDao
) {

    // ---- Chamadas de REDE (Retrofit) ----

    suspend fun getInstructors(): NetworkResult<List<InstructorDto>> {
        return try {
            val response = apiService.getInstructors()
            if (response.isSuccessful) {
                NetworkResult.Success(response.body() ?: emptyList())
            } else {
                NetworkResult.Error("Erro ${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun getInstructorById(id: String): NetworkResult<InstructorDto> {
        return try {
            val response = apiService.getInstructorById(id)
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error("Instrutor não encontrado")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun getInstructorByUserId(userId: String): NetworkResult<InstructorDto?> {
        return try {
            val response = apiService.getInstructorByUserId(userId)
            if (response.isSuccessful) {
                NetworkResult.Success(response.body()?.firstOrNull())
            } else {
                NetworkResult.Error("Erro ${response.code()}")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun createInstructor(dto: UpdateInstructorDto): NetworkResult<InstructorDto> {
        return try {
            val response = apiService.createInstructor(dto)
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error("Erro ao criar perfil")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun updateInstructor(id: String, dto: UpdateInstructorDto): NetworkResult<InstructorDto> {
        return try {
            val response = apiService.updateInstructor(id, dto)
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error("Erro ao atualizar perfil")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun getReviews(instrutorId: String): NetworkResult<List<ReviewDto>> {
        return try {
            val response = apiService.getReviewsByInstructor(instrutorId)
            if (response.isSuccessful) {
                NetworkResult.Success(response.body() ?: emptyList())
            } else {
                NetworkResult.Error("Erro ${response.code()}")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    suspend fun createReview(dto: CreateReviewDto): NetworkResult<ReviewDto> {
        return try {
            val response = apiService.createReview(dto)
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error("Erro ao enviar avaliação")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Erro de conexão")
        }
    }

    // ---- Operações LOCAIS (Room) ----

    fun getAllFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    suspend fun isFavorite(id: String): Boolean = favoriteDao.isFavorite(id) > 0

    suspend fun addFavorite(instructor: InstructorDto) {
        favoriteDao.insertFavorite(
            FavoriteEntity(
                instructorId = instructor.id?: return,
                nome = instructor.nome,
                foto = instructor.foto ?: "",
                cidade = instructor.cidade,
                bairro = instructor.bairro,
                preco = instructor.preco,
                nota = instructor.nota,
                totalAvaliacoes = instructor.totalAvaliacoes,
                telefone = instructor.telefone
            )
        )
    }

    suspend fun removeFavorite(instructorId: String) {
        val entity = favoriteDao.getFavoriteById(instructorId) ?: return
        favoriteDao.deleteFavorite(entity)
    }
}
