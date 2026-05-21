package com.ufscar.dirigemais.data.remote

import com.ufscar.dirigemais.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.*

/**
 * Interface do Retrofit — define os endpoints da API REST (MockAPI.io).
 * O Retrofit gera automaticamente a implementação dessa interface.
 *
 * Cada função é uma requisição HTTP:
 *   @GET  = leitura de dados
 *   @POST = envio de novo dado
 *   @PUT  = atualização de dado existente
 *
 * "suspend" = função de coroutine (executa em background, não trava a UI)
 * ⚠️ FORA DO MATERIAL: suspend functions / coroutines com Retrofit
 *    (o material usa .enqueue() com Callback — aqui usamos suspend por ser
 *     o padrão moderno com Compose e ViewModelScope)
 */
interface ApiService {

    // ---- Instrutores ----

    @GET("instrutores")
    suspend fun getInstructors(): Response<List<InstructorDto>>

    @GET("instrutores/{id}")
    suspend fun getInstructorById(
        @Path("id") id: String
    ): Response<InstructorDto>

    @GET("instrutores")
    suspend fun getInstructorByUserId(
        @Query("userId") userId: String
    ): Response<List<InstructorDto>>

    @POST("instrutores")
    suspend fun createInstructor(
        @Body instructor: UpdateInstructorDto
    ): Response<InstructorDto>

    @PUT("instrutores/{id}")
    suspend fun updateInstructor(
        @Path("id") id: String,
        @Body instructor: UpdateInstructorDto
    ): Response<InstructorDto>

    // ---- Avaliações ----

    @GET("avaliacoes")
    suspend fun getReviewsByInstructor(
        @Query("instrutorId") instrutorId: String
    ): Response<List<ReviewDto>>

    @POST("avaliacoes")
    suspend fun createReview(
        @Body review: CreateReviewDto
    ): Response<ReviewDto>
}
