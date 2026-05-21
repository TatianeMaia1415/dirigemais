package com.ufscar.dirigemais.data.remote;

/**
 * Interface do Retrofit — define os endpoints da API REST (MockAPI.io).
 * O Retrofit gera automaticamente a implementação dessa interface.
 *
 * Cada função é uma requisição HTTP:
 *  @GET  = leitura de dados
 *  @POST = envio de novo dado
 *  @PUT  = atualização de dado existente
 *
 * "suspend" = função de coroutine (executa em background, não trava a UI)
 * ⚠️ FORA DO MATERIAL: suspend functions / coroutines com Retrofit
 *   (o material usa .enqueue() com Callback — aqui usamos suspend por ser
 *    o padrão moderno com Compose e ViewModelScope)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/ufscar/dirigemais/data/remote/ApiService;", "", "createInstructor", "Lretrofit2/Response;", "Lcom/ufscar/dirigemais/data/remote/dto/InstructorDto;", "instructor", "Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;", "(Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReview", "Lcom/ufscar/dirigemais/data/remote/dto/ReviewDto;", "review", "Lcom/ufscar/dirigemais/data/remote/dto/CreateReviewDto;", "(Lcom/ufscar/dirigemais/data/remote/dto/CreateReviewDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstructorById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstructorByUserId", "", "userId", "getInstructors", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewsByInstructor", "instrutorId", "updateInstructor", "(Ljava/lang/String;Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "instrutores")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInstructors(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ufscar.dirigemais.data.remote.dto.InstructorDto>>> $completion);
    
    @retrofit2.http.GET(value = "instrutores/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInstructorById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion);
    
    @retrofit2.http.GET(value = "instrutores")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInstructorByUserId(@retrofit2.http.Query(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ufscar.dirigemais.data.remote.dto.InstructorDto>>> $completion);
    
    @retrofit2.http.POST(value = "instrutores")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createInstructor(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.UpdateInstructorDto instructor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion);
    
    @retrofit2.http.PUT(value = "instrutores/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateInstructor(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.UpdateInstructorDto instructor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion);
    
    @retrofit2.http.GET(value = "avaliacoes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReviewsByInstructor(@retrofit2.http.Query(value = "instrutorId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String instrutorId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ufscar.dirigemais.data.remote.dto.ReviewDto>>> $completion);
    
    @retrofit2.http.POST(value = "avaliacoes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createReview(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.CreateReviewDto review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ufscar.dirigemais.data.remote.dto.ReviewDto>> $completion);
}