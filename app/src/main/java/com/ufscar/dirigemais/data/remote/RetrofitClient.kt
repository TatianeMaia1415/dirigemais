package com.ufscar.dirigemais.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private const val BASE_URL = "https://6a0e2fb31736097c36099042.mockapi.io/api/v1/"

    // Interceptor para logar todas as requisições/respostas no Logcat (apenas debug)
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    // Instância única do Retrofit (padrão Singleton — boa prática das aulas)
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // converte JSON <-> Kotlin
            .build()
    }

    // Cria a implementação da interface ApiService
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
