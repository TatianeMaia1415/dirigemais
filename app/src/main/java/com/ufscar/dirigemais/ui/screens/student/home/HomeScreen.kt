package com.ufscar.dirigemais.ui.screens.student.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ufscar.dirigemais.R
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.ui.components.InstructorCard
import com.ufscar.dirigemais.ui.theme.*

/**
 * Tela 3 — Home do Aluno
 * Fiel ao protótipo Figma:
 * - Header verde-menta com saudação personalizada e avatar
 * - Barra de busca + ícone de filtro âmbar
 * - Chips de filtro: Todos / Menor preço / Perto de mim
 * - Lista de cards de instrutores
 * - Bottom Navigation: Início | Buscar | Perfil
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    userName: String,
    onInstructorClick: (String) -> Unit,
    onFavoritesClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val uiState     by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    var activeFilter by remember { mutableStateOf("todos") }
    var selectedNav  by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            // Bottom Navigation — igual ao Figma: Início | Buscar | Perfil
            NavigationBar(
                containerColor = SurfaceWhite,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = selectedNav == 0,
                    onClick  = { selectedNav = 0 },
                    icon     = { Icon(Icons.Filled.Home, null) },
                    label    = { Text(stringResource(R.string.nav_home)) },
                    colors   = NavigationBarItemDefaults.colors(
                        selectedIconColor   = DarkGreen,
                        selectedTextColor   = DarkGreen,
                        indicatorColor      = MintGreen.copy(alpha = 0.4f)
                    )
                )
                NavigationBarItem(
                    selected = selectedNav == 1,
                    onClick  = { selectedNav = 1; onFavoritesClick() },
                    icon     = { Icon(Icons.Filled.Favorite, null) },
                    label    = { Text(stringResource(R.string.nav_favorites)) },
                    colors   = NavigationBarItemDefaults.colors(
                        selectedIconColor   = DarkGreen,
                        selectedTextColor   = DarkGreen,
                        indicatorColor      = MintGreen.copy(alpha = 0.4f)
                    )
                )
                NavigationBarItem(
                    selected = selectedNav == 2,
                    onClick  = { selectedNav = 2; onSettingsClick() },
                    icon     = { Icon(Icons.Filled.Person, null) },
                    label    = { Text("Perfil") },
                    colors   = NavigationBarItemDefaults.colors(
                        selectedIconColor   = DarkGreen,
                        selectedTextColor   = DarkGreen,
                        indicatorColor      = MintGreen.copy(alpha = 0.4f)
                    )
                )
            }
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {

            // ---- Header verde-menta (como no Figma) ----
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(listOf(MintGreen, MintGreen.copy(alpha = 0.7f)))
                    )
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Column {
                    Row(
                        modifier             = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment    = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text       = "Olá ${userName.split(" ").firstOrNull() ?: userName}!",
                                fontSize   = 26.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color      = BrownText
                            )
                            Text(
                                text  = "Encontre seu Instrutor ideal",
                                color = BrownTextLight,
                                fontSize = 14.sp
                            )
                        }
                        // Avatar com inicial do nome (como no Figma)
                        Box(
                            modifier         = Modifier
                                .size(48.dp)
                                .background(DarkGreen, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text       = userName.firstOrNull()?.uppercase() ?: "U",
                                color      = SurfaceWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize   = 20.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(16.dp))

                    // Barra de busca + ícone de filtro âmbar (como no Figma)
                    Row(
                        modifier          = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value           = searchQuery,
                            onValueChange   = {
                                viewModel.onSearchQueryChanged(it)
                                activeFilter = "todos"
                            },
                            placeholder     = { Text(stringResource(R.string.search_hint), color = GrayMedium, fontSize = 14.sp) },
                            leadingIcon     = { Icon(Icons.Filled.Search, null, tint = GrayMedium) },
                            singleLine      = true,
                            modifier        = Modifier.weight(1f),
                            shape           = RoundedCornerShape(50.dp),
                            colors          = OutlinedTextFieldDefaults.colors(
                                unfocusedContainerColor = SurfaceWhite,
                                focusedContainerColor   = SurfaceWhite,
                                unfocusedBorderColor    = SurfaceWhite,
                                focusedBorderColor      = DarkGreen
                            )
                        )
                        // Ícone de filtro âmbar (hambúrguer, como no Figma)
                        Box(
                            modifier         = Modifier
                                .size(48.dp)
                                .background(Amber, RoundedCornerShape(12.dp))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.FilterList, "Filtros", tint = BrownText)
                        }
                    }
                }
            }

            // ---- Chips de filtro (como no Figma) ----
            Row(
                modifier             = Modifier
                    .fillMaxWidth()
                    .background(SurfaceWhite)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("todos" to "Todos", "menor_preco" to "Menor preço"/*, "perto" to "Perto de mim"*/).forEach { (value, label) ->
                    val isSelected = activeFilter == value
                    FilterChip(
                        selected = isSelected,
                        onClick  = {
                            activeFilter = value
                            when (value) {
                                "menor_preco" -> viewModel.sortByPrice()
                                "todos" -> viewModel.clearFilter()
                                else -> viewModel.clearFilter()
                            }
                        },
                        label    = { Text(label, fontSize = 13.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                        colors   = FilterChipDefaults.filterChipColors(
                            selectedContainerColor  = Amber,
                            selectedLabelColor      = BrownText,
                            containerColor          = SurfaceWhite,
                            labelColor              = BrownTextLight
                        ),
                        border   = FilterChipDefaults.filterChipBorder(
                            enabled           = true,
                            selected          = isSelected,
                            selectedBorderColor = Amber,
                            borderColor         = GrayBorder
                        )
                    )
                }
            }

            // ---- Lista de instrutores ----
            Box(modifier = Modifier.fillMaxSize().background(BackgroundMint)) {
                when (uiState) {
                    is NetworkResult.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = DarkGreen)
                    }
                    is NetworkResult.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text((uiState as NetworkResult.Error).message, color = MaterialTheme.colorScheme.error)
                            Spacer(Modifier.height(8.dp))
                            Button(onClick = { viewModel.loadInstructors() },
                                colors = ButtonDefaults.buttonColors(containerColor = DarkGreen)) {
                                Text(stringResource(R.string.retry))
                            }
                        }
                    }
                    is NetworkResult.Success -> {
                        val instructors = (uiState as NetworkResult.Success<List<InstructorDto>>).data
                        if (instructors.isEmpty()) {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text(stringResource(R.string.no_instructors), color = BrownTextLight)
                            }
                        } else {
                            LazyColumn(
                                contentPadding      = PaddingValues(16.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                item {
                                    Row(
                                        modifier             = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment    = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text       = "Instrutores próximos",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize   = 18.sp,
                                            color      = BrownText
                                        )
                                        TextButton(onClick = {}) {
                                            Text("Ver todos >", color = DarkGreen, fontSize = 13.sp)
                                        }
                                    }
                                }
                                items(instructors) { instructor ->
                                    InstructorCard(
                                        instructor        = instructor,
                                        onClick           = { onInstructorClick(instructor.id?:"") },
                                        onFavoriteClick   = {},
                                        onWhatsappClick   = {}
                                    )
                                }
                                item { Spacer(Modifier.height(8.dp)) }
                            }
                        }
                    }
                }
            }
        }
    }
}
