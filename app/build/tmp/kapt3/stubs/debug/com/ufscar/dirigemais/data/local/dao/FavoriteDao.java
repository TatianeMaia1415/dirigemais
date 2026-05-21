package com.ufscar.dirigemais.data.local.dao;

/**
 * DAO = Data Access Object
 * Interface com os métodos de acesso ao banco de dados.
 * O Room gera automaticamente a implementação em tempo de compilação.
 *
 * @Dao → marca como DAO para o Room.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/ufscar/dirigemais/data/local/dao/FavoriteDao;", "", "deleteFavorite", "", "favorite", "Lcom/ufscar/dirigemais/data/local/entity/FavoriteEntity;", "(Lcom/ufscar/dirigemais/data/local/entity/FavoriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "getFavoriteById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFavorite", "isFavorite", "", "app_debug"})
@androidx.room.Dao()
public abstract interface FavoriteDao {
    
    /**
     * Flow<List<>> → retorna uma "stream" reativa.
     * Quando o banco mudar, a UI é notificada automaticamente — sem precisar chamar de novo.
     * ⚠️ FORA DO MATERIAL: Flow (o material usa LiveData — aqui usamos Flow por ser
     *   mais idiomático com Compose e coroutines)
     */
    @androidx.room.Query(value = "SELECT * FROM favorites")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ufscar.dirigemais.data.local.entity.FavoriteEntity>> getAllFavorites();
    
    @androidx.room.Query(value = "SELECT * FROM favorites WHERE instructorId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavoriteById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ufscar.dirigemais.data.local.entity.FavoriteEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFavorite(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.local.entity.FavoriteEntity favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.local.entity.FavoriteEntity favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM favorites WHERE instructorId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}