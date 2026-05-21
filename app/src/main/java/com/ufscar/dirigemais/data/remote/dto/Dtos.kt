package com.ufscar.dirigemais.data.remote.dto

import com.google.gson.annotations.SerializedName


data class InstructorDto(
    @SerializedName("id")             val id: String? = null,
    @SerializedName("nome")           val nome: String,
    @SerializedName("foto")           val foto: String?,
    @SerializedName("cidade")         val cidade: String,
    @SerializedName("bairro")         val bairro: String,
    @SerializedName("descricao")      val descricao: String,
    @SerializedName("preco")          val preco: Double,
    @SerializedName("nota")           val nota: Double,
    @SerializedName("totalAvaliacoes") val totalAvaliacoes: Int,
    @SerializedName("telefone")       val telefone: String,
    @SerializedName("userId")         val userId: String,
    @SerializedName("disponibilidade") val disponibilidade: String?
)

data class ReviewDto(
    @SerializedName("id")           val id: String,
    @SerializedName("instrutorId")  val instrutorId: String,
    @SerializedName("alunoId")      val alunoId: String,
    @SerializedName("alunoNome")    val alunoNome: String,
    @SerializedName("nota")         val nota: Int,
    @SerializedName("comentario")   val comentario: String,
    @SerializedName("data")         val data: String
)

/** DTO usado apenas no POST de avaliação */
data class CreateReviewDto(
    @SerializedName("instrutorId") val instrutorId: String,
    @SerializedName("alunoId")     val alunoId: String,
    @SerializedName("alunoNome")   val alunoNome: String,
    @SerializedName("nota")        val nota: Int,
    @SerializedName("comentario")  val comentario: String,
    @SerializedName("data")        val data: String
)

/** DTO usado no PUT de edição de perfil do instrutor */
data class UpdateInstructorDto(
    @SerializedName("nome")           val nome: String,
    @SerializedName("foto")           val foto: String,
    @SerializedName("cidade")         val cidade: String,
    @SerializedName("bairro")         val bairro: String,
    @SerializedName("descricao")      val descricao: String,
    @SerializedName("preco")          val preco: Double,
    @SerializedName("telefone")       val telefone: String,
    @SerializedName("disponibilidade") val disponibilidade: String
)
