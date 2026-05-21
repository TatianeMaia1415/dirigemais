package com.ufscar.dirigemais

import com.ufscar.dirigemais.data.local.dao.FavoriteDao
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.remote.ApiService
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.data.repository.InstructorRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import retrofit2.Response

/**
 * Testes unitários do InstructorRepository (R6).
 * Mockito cria "dublês" das dependências — testa sem rede ou banco real.
 */
class InstructorRepositoryTest {

    private lateinit var mockApiService: ApiService
    private lateinit var mockFavoriteDao: FavoriteDao
    private lateinit var repository: InstructorRepository

    private val fakeInstructor = InstructorDto(
        id = "1", nome = "Carlos Silva", foto = null,
        cidade = "São Carlos", bairro = "Centro", descricao = "Ótimo instrutor",
        preco = 80.0, nota = 4.5, totalAvaliacoes = 10, telefone = "16999999999",
        userId = "user1", disponibilidade = "Seg-Sex 08h-18h"
    )

    @Before
    fun setup() {
        mockApiService  = mock()
        mockFavoriteDao = mock()
        repository = InstructorRepository(mockApiService, mockFavoriteDao)
    }

    @Test
    fun `getInstructors retorna Success quando API responde`() = runTest {
        whenever(mockApiService.getInstructors())
            .thenReturn(Response.success(listOf(fakeInstructor)))

        val result = repository.getInstructors()

        assertTrue(result is NetworkResult.Success)
        assertEquals(1, (result as NetworkResult.Success).data.size)
        assertEquals("Carlos Silva", result.data[0].nome)
    }

    @Test
    fun `getInstructors retorna Error quando API lança exceção`() = runTest {
        whenever(mockApiService.getInstructors())
            .thenThrow(RuntimeException("Sem internet"))

        val result = repository.getInstructors()

        assertTrue(result is NetworkResult.Error)
        assertTrue((result as NetworkResult.Error).message.contains("Sem internet"))
    }

    @Test
    fun `getInstructors retorna lista vazia quando body é null`() = runTest {
        whenever(mockApiService.getInstructors()).thenReturn(Response.success(null))

        val result = repository.getInstructors()

        assertTrue(result is NetworkResult.Success)
        assertEquals(0, (result as NetworkResult.Success).data.size)
    }

    @Test
    fun `addFavorite chama insertFavorite com dados corretos`() = runTest {
        val captor = argumentCaptor<FavoriteEntity>()

        repository.addFavorite(fakeInstructor)

        verify(mockFavoriteDao).insertFavorite(captor.capture())
        assertEquals("1", captor.firstValue.instructorId)
        assertEquals("Carlos Silva", captor.firstValue.nome)
        assertEquals(80.0, captor.firstValue.preco, 0.001)
    }

    @Test
    fun `isFavorite retorna true quando DAO retorna contagem maior que zero`() = runTest {
        whenever(mockFavoriteDao.isFavorite("1")).thenReturn(1)
        assertTrue(repository.isFavorite("1"))
    }

    @Test
    fun `isFavorite retorna false quando DAO retorna zero`() = runTest {
        whenever(mockFavoriteDao.isFavorite("99")).thenReturn(0)
        assertFalse(repository.isFavorite("99"))
    }

    @Test
    fun `getAllFavorites retorna flow do DAO`() = runTest {
        val fakeList = listOf(
            FavoriteEntity("1", "Carlos", "", "São Carlos", "Centro", 80.0, 4.5, 10, "16999999999")
        )
        whenever(mockFavoriteDao.getAllFavorites()).thenReturn(flowOf(fakeList))

        repository.getAllFavorites().collect { favorites ->
            assertEquals(1, favorites.size)
            assertEquals("Carlos", favorites[0].nome)
        }
    }
}
