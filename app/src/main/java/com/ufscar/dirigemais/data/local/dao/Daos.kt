package com.ufscar.dirigemais.data.local.dao

import androidx.room.*
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteDao {

   
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
