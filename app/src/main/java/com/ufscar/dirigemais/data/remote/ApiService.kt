package com.ufscar.dirigemais.data.remote

import com.ufscar.dirigemais.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.*

 
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
