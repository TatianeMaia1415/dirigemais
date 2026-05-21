package com.ufscar.dirigemais.ui.screens.student.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.data.remote.dto.ReviewDto
import com.ufscar.dirigemais.data.repository.InstructorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InstructorDetailViewModel(
    private val repository: InstructorRepository
) : ViewModel() {

    private val _instructor = MutableStateFlow<NetworkResult<InstructorDto>>(NetworkResult.Loading)
    val instructor: StateFlow<NetworkResult<InstructorDto>> = _instructor

    private val _reviews = MutableStateFlow<NetworkResult<List<ReviewDto>>>(NetworkResult.Loading)
    val reviews: StateFlow<NetworkResult<List<ReviewDto>>> = _reviews

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite

    fun loadInstructor(id: String) {
        viewModelScope.launch {
            _instructor.value = NetworkResult.Loading
            _instructor.value = repository.getInstructorById(id)
            _isFavorite.value = repository.isFavorite(id)
            // Busca avaliações da API (R3)
            _reviews.value = NetworkResult.Loading
            _reviews.value = repository.getReviews(id)
        }
    }

    fun toggleFavorite(instructor: InstructorDto) {
        viewModelScope.launch {
            if (_isFavorite.value) {
                repository.removeFavorite(instructor.id?: return@launch)   // deleta do Room (R4)
                _isFavorite.value = false
            } else {
                repository.addFavorite(instructor)          // salva no Room (R4)
                _isFavorite.value = true
            }
        }
    }

    class Factory(private val repo: InstructorRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            InstructorDetailViewModel(repo) as T
    }
}
