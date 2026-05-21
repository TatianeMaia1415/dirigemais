package com.ufscar.dirigemais.data.repository;

/**
 * Repository = "Fonte única da verdade" (Single Source of Truth).
 *
 * A ViewModel não sabe SE os dados vêm da rede ou do banco local.
 * Ela só pede ao Repository, e o Repository decide.
 *
 * Essa é a separação de responsabilidades da arquitetura MVVM:
 *  View → ViewModel → Repository → [API ou Room]
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u000e\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170\rH\u0086@\u00a2\u0006\u0002\u0010 J\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00170\r2\u0006\u0010\"\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ$\u0010\'\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/ufscar/dirigemais/data/repository/InstructorRepository;", "", "apiService", "Lcom/ufscar/dirigemais/data/remote/ApiService;", "favoriteDao", "Lcom/ufscar/dirigemais/data/local/dao/FavoriteDao;", "(Lcom/ufscar/dirigemais/data/remote/ApiService;Lcom/ufscar/dirigemais/data/local/dao/FavoriteDao;)V", "addFavorite", "", "instructor", "Lcom/ufscar/dirigemais/data/remote/dto/InstructorDto;", "(Lcom/ufscar/dirigemais/data/remote/dto/InstructorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstructor", "Lcom/ufscar/dirigemais/data/remote/NetworkResult;", "dto", "Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;", "(Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReview", "Lcom/ufscar/dirigemais/data/remote/dto/ReviewDto;", "Lcom/ufscar/dirigemais/data/remote/dto/CreateReviewDto;", "(Lcom/ufscar/dirigemais/data/remote/dto/CreateReviewDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/ufscar/dirigemais/data/local/entity/FavoriteEntity;", "getInstructorById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstructorByUserId", "userId", "getInstructors", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviews", "instrutorId", "isFavorite", "", "removeFavorite", "instructorId", "updateInstructor", "(Ljava/lang/String;Lcom/ufscar/dirigemais/data/remote/dto/UpdateInstructorDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class InstructorRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.remote.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.local.dao.FavoriteDao favoriteDao = null;
    
    public InstructorRepository(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.local.dao.FavoriteDao favoriteDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInstructors(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<? extends java.util.List<com.ufscar.dirigemais.data.remote.dto.InstructorDto>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInstructorById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInstructorByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createInstructor(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.UpdateInstructorDto dto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateInstructor(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.UpdateInstructorDto dto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getReviews(@org.jetbrains.annotations.NotNull()
    java.lang.String instrutorId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<? extends java.util.List<com.ufscar.dirigemais.data.remote.dto.ReviewDto>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createReview(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.CreateReviewDto dto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.ReviewDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ufscar.dirigemais.data.local.entity.FavoriteEntity>> getAllFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.InstructorDto instructor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String instructorId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}