package com.ufscar.dirigemais.ui.screens.student.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ufscar.dirigemais.R
import com.ufscar.dirigemais.ui.components.FavoriteCard

/**
 * Tela 5 — Favoritos
 * Exibe instrutores salvos localmente no banco Room.
 * Os dados vêm de um Flow reativo — atualiza automaticamente quando o banco muda.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
    onInstructorClick: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val favorites by viewModel.favorites.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.favorites_title)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.nav_back))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        if (favorites.isEmpty()) {
            Box(
                modifier         = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text      = stringResource(R.string.no_favorites),
                    textAlign = TextAlign.Center,
                    color     = MaterialTheme.colorScheme.outline
                )
            }
        } else {
            LazyColumn(
                modifier            = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding      = PaddingValues(vertical = 16.dp)
            ) {
                items(favorites, key = { it.instructorId }) { fav ->
                    FavoriteCard(
                        favorite  = fav,
                        onClick   = { onInstructorClick(fav.instructorId) },
                        onRemove  = { viewModel.removeFavorite(fav.instructorId) }
                    )
                }
            }
        }
    }
}
