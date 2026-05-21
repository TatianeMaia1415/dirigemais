package com.ufscar.dirigemais.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ufscar.dirigemais.data.local.dao.FavoriteDao
import com.ufscar.dirigemais.data.local.dao.UserDao
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.local.entity.UserEntity

/**
 * Classe principal do banco de dados Room.
 *
 * @Database → anota a classe como banco de dados Room.
 *   entities → lista de tabelas (cada @Entity vira uma tabela).
 *   version  → versão do schema. Incremente quando mudar a estrutura.
 *
 * Implementa o padrão Singleton (boa prática das aulas):
 * garante que só existe UMA instância do banco em toda a aplicação.
 */
@Database(
    entities = [FavoriteEntity::class, UserEntity::class],
    version  = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile  // garante visibilidade entre threads
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            // synchronized → evita que duas threads criem o banco ao mesmo tempo
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dirige_mais_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
