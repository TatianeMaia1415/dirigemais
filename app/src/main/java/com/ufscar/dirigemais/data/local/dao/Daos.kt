package com.ufscar.dirigemais.data.local.dao

import androidx.room.*
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO = Data Access Object
 * Interface com os métodos de acesso ao banco de dados.
 * O Room gera automaticamente a implementação em tempo de compilação.
 *
 * @Dao → marca como DAO para o Room.
 */
@Dao
interface FavoriteDao {

    /**
     * Flow<List<>> → retorna uma "stream" reativa.
     * Quando o banco mudar, a UI é notificada automaticamente — sem precisar chamar de novo.
     * ⚠️ FORA DO MATERIAL: Flow (o material usa LiveData — aqui usamos Flow por ser
     *    mais idiomático com Compose e coroutines)
     */
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT * FROM favorites WHERE instructorId = :id")
    suspend fun getFavoriteById(id: String): FavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

    @Query("SELECT COUNT(*) FROM favorites WHERE instructorId = :id")
    suspend fun isFavorite(id: String): Int
}

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: UserEntity): Long

    @Query("SELECT * FROM users WHERE email = :email AND senha = :senha LIMIT 1")
    suspend fun getUserByCredentials(email: String, senha: String): UserEntity?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): UserEntity?

    @Query("UPDATE users SET instrutorId = :instrutorId WHERE email = :email")
    suspend fun updateInstructorId(email: String, instrutorId: String)
}
