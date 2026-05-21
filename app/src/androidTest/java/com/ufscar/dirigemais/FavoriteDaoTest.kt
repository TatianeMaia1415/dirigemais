package com.ufscar.dirigemais

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ufscar.dirigemais.data.local.AppDatabase
import com.ufscar.dirigemais.data.local.dao.FavoriteDao
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Teste instrumentado do FavoriteDao (roda no device/emulador).
 *
 * Usa um banco Room IN-MEMORY (apenas na memória, sem arquivo em disco),
 * o que garante que cada teste começa com um banco limpo.
 *
 * @RunWith(AndroidJUnit4::class) é necessário para testes que precisam
 * do contexto do Android (como Room).
 */
@RunWith(AndroidJUnit4::class)
class FavoriteDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: FavoriteDao

    private val fakeEntity = FavoriteEntity(
        instructorId = "inst_001",
        nome = "Maria Oliveira",
        foto = "https://example.com/foto.jpg",
        cidade = "Campinas",
        bairro = "Barão Geraldo",
        preco = 90.0,
        nota = 4.8,
        totalAvaliacoes = 25,
        telefone = "19988887777"
    )

    @Before
    fun setup() {
        // Cria banco em memória para os testes — não persiste dados
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.favoriteDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertFavorite_and_getAllFavorites() = runTest {
        dao.insertFavorite(fakeEntity)

        val result = dao.getAllFavorites().first()

        assertEquals("Deve ter 1 favorito", 1, result.size)
        assertEquals("inst_001", result[0].instructorId)
        assertEquals("Maria Oliveira", result[0].nome)
    }

    @Test
    fun deleteFavorite_removes_from_database() = runTest {
        dao.insertFavorite(fakeEntity)
        dao.deleteFavorite(fakeEntity)

        val result = dao.getAllFavorites().first()

        assertEquals("Lista deve estar vazia após deletar", 0, result.size)
    }

    @Test
    fun isFavorite_returns_correct_count() = runTest {
        dao.insertFavorite(fakeEntity)

        val count = dao.isFavorite("inst_001")
        assertEquals("Deve retornar 1 para ID existente", 1, count)

        val notFound = dao.isFavorite("nao_existe")
        assertEquals("Deve retornar 0 para ID inexistente", 0, notFound)
    }

    @Test
    fun insertFavorite_replace_on_conflict() = runTest {
        dao.insertFavorite(fakeEntity)
        // Insere novamente com mesmo ID mas preço diferente (REPLACE)
        dao.insertFavorite(fakeEntity.copy(preco = 100.0))

        val result = dao.getAllFavorites().first()

        assertEquals("Não deve duplicar — apenas substituir", 1, result.size)
        assertEquals("Preço deve ser atualizado", 100.0, result[0].preco, 0.001)
    }
}
