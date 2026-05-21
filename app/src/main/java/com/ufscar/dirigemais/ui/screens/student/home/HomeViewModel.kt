package com.ufscar.dirigemais.ui.screens.student.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.data.repository.InstructorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: InstructorRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<NetworkResult<List<InstructorDto>>>(NetworkResult.Loading)
    val uiState: StateFlow<NetworkResult<List<InstructorDto>>> = _uiState

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private var allInstructors: List<InstructorDto> = emptyList()

    init {
        loadInstructors()
    }

    fun loadInstructors() {
        viewModelScope.launch {
            _uiState.value = NetworkResult.Loading
            val result = repository.getInstructors()
            if (result is NetworkResult.Success) {
                allInstructors = result.data
                applyFilter()
            } else {
                _uiState.value = result
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        applyFilter()
    }

    fun sortByPrice() {
        val current = (uiState.value as? NetworkResult.Success)?.data ?: return
        _uiState.value = NetworkResult.Success(current.sortedBy { it.preco })
    }

    fun clearFilter() {
        _searchQuery.value = ""
        applyFilter()
    }

    private fun applyFilter() {
        val query = _searchQuery.value.trim().lowercase()
        val filtered = if (query.isEmpty()) {
            allInstructors
        } else {
            allInstructors.filter {
                it.cidade.lowercase().contains(query) ||
                it.bairro.lowercase().contains(query) ||
                it.nome.lowercase().contains(query)
            }
        }
        _uiState.value = NetworkResult.Success(filtered)
    }

    class Factory(private val repo: InstructorRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = HomeViewModel(repo) as T
    }
}
