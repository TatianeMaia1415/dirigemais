package com.ufscar.dirigemais.ui.screens.student.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ufscar.dirigemais.R
import com.ufscar.dirigemais.data.remote.NetworkResult
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.ui.components.ReviewCard
import com.ufscar.dirigemais.ui.components.StarRatingBar
import com.ufscar.dirigemais.ui.theme.*

/**
 * Tela 4 — Detalhes do Instrutor
 * Cobre: R3 (GET instrutor + avaliações da API) e R4 (favoritar via Room)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstructorDetailScreen(
    instructorId: String,
    viewModel: InstructorDetailViewModel,
    onNavigateBack: () -> Unit
) {
    val instructorState by viewModel.instructor.collectAsState()
    val reviewsState    by viewModel.reviews.collectAsState()
    val isFavorite      by viewModel.isFavorite.collectAsState()
    val context         = LocalContext.current

    LaunchedEffect(instructorId) { viewModel.loadInstructor(instructorId) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.screen_details), color = BrownText) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.nav_back), tint = BrownText)
                    }
                },
                actions = {
                    if (instructorState is NetworkResult.Success) {
                        // Botão favoritar na AppBar
                        IconButton(onClick = {
                            val inst = (instructorState as NetworkResult.Success<InstructorDto>).data
                            viewModel.toggleFavorite(inst)
                        }) {
                            Icon(
                                imageVector        = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                                contentDescription = stringResource(R.string.add_favorite),
                                tint               = if (isFavorite) Amber else BrownText
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MintGreen)
            )
        }
    ) { padding ->
        when (instructorState) {
            is NetworkResult.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = DarkGreen)
            }
            is NetworkResult.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text((instructorState as NetworkResult.Error).message, color = MaterialTheme.colorScheme.error)
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { viewModel.loadInstructor(instructorId) },
                        colors = ButtonDefaults.buttonColors(containerColor = DarkGreen)) {
                        Text(stringResource(R.string.retry))
                    }
                }
            }
            is NetworkResult.Success -> {
                val instructor = (instructorState as NetworkResult.Success<InstructorDto>).data

                LazyColumn(
                    modifier       = Modifier.fillMaxSize().padding(padding),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    // ── Cabeçalho verde com foto e dados ──
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Brush.verticalGradient(listOf(MintGreen, MintGreen.copy(alpha = 0.4f)))
                                )
                                .padding(20.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                                AsyncImage(
                                    model              = instructor.foto ?: "",
                                    contentDescription = instructor.nome,
                                    modifier           = Modifier.size(100.dp).clip(CircleShape),
                                    contentScale       = ContentScale.Crop
                                )
                                Spacer(Modifier.height(12.dp))
                                Text(instructor.nome, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = BrownText)
                                Text("${instructor.cidade} — ${instructor.bairro}", color = BrownTextLight)
                                Spacer(Modifier.height(6.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Filled.Star, null, tint = Amber, modifier = Modifier.size(18.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text(stringResource(R.string.rating_label, instructor.nota, instructor.totalAvaliacoes), color = BrownTextLight)
                                }
                                Spacer(Modifier.height(8.dp))
                                // Badge de preço
                                Card(colors = CardDefaults.cardColors(containerColor = Amber), shape = RoundedCornerShape(50.dp)) {
                                    Text(
                                        stringResource(R.string.price_per_hour, instructor.preco),
                                        modifier   = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                                        fontWeight = FontWeight.ExtraBold,
                                        color      = BrownText
                                    )
                                }
                            }
                        }
                    }

                    // ── Sobre ──
                    item {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {
                            Text(stringResource(R.string.detail_about), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = BrownText)
                            Spacer(Modifier.height(6.dp))
                            Text(instructor.descricao.ifBlank { stringResource(R.string.no_description) }, color = BrownTextLight)
                        }
                    }

                    // ── Disponibilidade ──
                    if (!instructor.disponibilidade.isNullOrBlank()) {
                        item {
                            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                                Text(stringResource(R.string.detail_schedule), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = BrownText)
                                Spacer(Modifier.height(6.dp))
                                Text(instructor.disponibilidade, color = BrownTextLight)
                            }
                        }
                    }

                    // ── Botão WhatsApp ──
                    item {
                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Button(
                                onClick = {
                                    val uri = Uri.parse("https://wa.me/55${instructor.telefone}")
                                    context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                                },
                                modifier = Modifier.fillMaxWidth().height(50.dp),
                                shape    = RoundedCornerShape(50.dp),
                                colors   = ButtonDefaults.buttonColors(containerColor = DarkGreen)
                            ) {
                                Icon(Icons.Filled.Chat, null)
                                Spacer(Modifier.width(8.dp))
                                Text(stringResource(R.string.contact_whatsapp), fontWeight = FontWeight.Bold)
                            }
                            // Botão Favoritar
                            OutlinedButton(
                                onClick  = { viewModel.toggleFavorite(instructor) },
                                modifier = Modifier.fillMaxWidth().height(50.dp),
                                shape    = RoundedCornerShape(50.dp),
                                colors   = ButtonDefaults.outlinedButtonColors(contentColor = if (isFavorite) Amber else DarkGreen)
                            ) {
                                Icon(if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder, null)
                                Spacer(Modifier.width(8.dp))
                                Text(if (isFavorite) stringResource(R.string.remove_favorite) else stringResource(R.string.add_favorite))
                            }
                        }
                    }

                    // ── Avaliações ──
                    item {
                        Text(
                            stringResource(R.string.detail_reviews),
                            modifier   = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize   = 16.sp,
                            color      = BrownText
                        )
                    }
                    when (reviewsState) {
                        is NetworkResult.Loading -> item { Box(Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) { CircularProgressIndicator(color = DarkGreen) } }
                        is NetworkResult.Success -> {
                            val reviews = (reviewsState as NetworkResult.Success).data
                            if (reviews.isEmpty()) {
                                item { Text(stringResource(R.string.no_reviews), modifier = Modifier.padding(horizontal = 20.dp), color = BrownTextLight) }
                            } else {
                                items(reviews.size) { i ->
                                    Box(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                                        ReviewCard(reviews[i])
                                    }
                                }
                            }
                        }
                        is NetworkResult.Error -> item { Text((reviewsState as NetworkResult.Error).message, modifier = Modifier.padding(16.dp), color = MaterialTheme.colorScheme.error) }
                    }
                }
            }
        }
    }
}
