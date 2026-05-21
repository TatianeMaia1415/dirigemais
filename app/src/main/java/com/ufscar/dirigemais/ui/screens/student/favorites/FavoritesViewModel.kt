package com.ufscar.dirigemais.ui.screens.student.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.repository.InstructorRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: InstructorRepository) : ViewModel() {

    // stateIn converte Flow em StateFlow, que é observável pelo Compose
    val favorites: StateFlow<List<FavoriteEntity>> = repository
        .getAllFavorites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun removeFavorite(instructorId: String) {
        viewModelScope.launch {
            repository.removeFavorite(instructorId)
        }
    }

    class Factory(private val repo: InstructorRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = FavoritesViewModel(repo) as T
    }
}
