package com.ufscar.dirigemais.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity
import com.ufscar.dirigemais.data.remote.dto.InstructorDto
import com.ufscar.dirigemais.data.remote.dto.ReviewDto
import com.ufscar.dirigemais.ui.theme.*

@Composable
fun InstructorCard(
    instructor: InstructorDto,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onWhatsappClick: () -> Unit,
    isFavorite: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier  = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape     = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors    = CardDefaults.cardColors(containerColor = SurfaceWhite)
    ) {
        Row(
            modifier          = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto circular
            AsyncImage(
                model              = instructor.foto ?: "",
                contentDescription = instructor.nome,
                modifier           = Modifier
                    .size(68.dp)
                    .clip(CircleShape),
                contentScale       = ContentScale.Crop
            )
            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                // Nome
                Text(
                    text       = instructor.nome,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize   = 15.sp,
                    color      = BrownText,
                    maxLines   = 1,
                    overflow   = TextOverflow.Ellipsis
                )
                // Cidade
                Text(
                    text     = "${instructor.cidade} - ${instructor.bairro}",
                    fontSize = 12.sp,
                    color    = BrownTextLight
                )
                // Estrela + avaliações
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, null, tint = Amber, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(2.dp))
                    Text(
                        text     = "%.1f (${instructor.totalAvaliacoes} avaliações)".format(instructor.nota),
                        fontSize = 12.sp,
                        color    = BrownTextLight
                    )
                }
                Spacer(Modifier.height(8.dp))
                // Botão WhatsApp (verde, como no Figma)
                Button(
                    onClick        = onWhatsappClick,
                    colors         = ButtonDefaults.buttonColors(containerColor = DarkGreen),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier       = Modifier.height(28.dp),
                    shape          = RoundedCornerShape(50.dp)
                ) {
                    Text("Whatsapp", fontSize = 11.sp, color = SurfaceWhite, fontWeight = FontWeight.SemiBold)
                }
            }

            // Coluna direita: preço âmbar + coração
            Column(horizontalAlignment = Alignment.End) {
                // Preço âmbar (como no Figma)
                Card(
                    colors = CardDefaults.cardColors(containerColor = Amber),
                    shape  = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text     = "R$ %.0f,00h".format(instructor.preco),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color    = BrownText
                    )
                }
                Spacer(Modifier.height(20.dp))
                // Coração favoritar (outlined, como no Figma)
                IconButton(
                    onClick  = onFavoriteClick,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color.Red.copy(alpha = 0.7f) else GrayMedium,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}

// Card para tela de Favoritos
@Composable
fun FavoriteCard(
    favorite: FavoriteEntity,
    onClick: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier  = modifier.fillMaxWidth().clickable { onClick() },
        shape     = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors    = CardDefaults.cardColors(containerColor = SurfaceWhite)
    ) {
        Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model              = favorite.foto,
                contentDescription = favorite.nome,
                modifier           = Modifier.size(64.dp).clip(CircleShape),
                contentScale       = ContentScale.Crop
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(favorite.nome, fontWeight = FontWeight.Bold, color = BrownText)
                Text("${favorite.cidade} — ${favorite.bairro}", fontSize = 12.sp, color = BrownTextLight)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, null, tint = Amber, modifier = Modifier.size(14.dp))
                    Text(" %.1f".format(favorite.nota), fontSize = 12.sp, color = BrownTextLight)
                }
                Text("R$ %.0f/h".format(favorite.preco), fontWeight = FontWeight.Bold, color = DarkGreen)
            }
            IconButton(onClick = onRemove) {
                Icon(Icons.Filled.Favorite, "Remover", tint = Color.Red.copy(alpha = 0.7f))
            }
        }
    }
}

// ============================================================
// StarRatingBar — estrelas clicáveis (âmbar, como no Figma)
// ============================================================
@Composable
fun StarRatingBar(
    rating: Int,
    onRatingChanged: (Int) -> Unit,
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
    editable: Boolean = true
) {
    Row(modifier = modifier) {
        for (i in 1..maxStars) {
            Icon(
                imageVector        = if (i <= rating) Icons.Filled.Star else Icons.Filled.StarBorder,
                contentDescription = "Estrela $i",
                tint               = Amber,
                modifier           = Modifier
                    .size(36.dp)
                    .then(if (editable) Modifier.clickable { onRatingChanged(i) } else Modifier)
            )
        }
    }
}

// ============================================================
// ReviewCard — card de avaliação
// ============================================================
@Composable
fun ReviewCard(review: ReviewDto, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape    = RoundedCornerShape(12.dp),
        colors   = CardDefaults.cardColors(containerColor = Color(0xFFF5FBF8))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier              = Modifier.fillMaxWidth()
            ) {
                Text(review.alunoNome, fontWeight = FontWeight.Bold, color = BrownText)
                Text(review.data, fontSize = 12.sp, color = GrayMedium)
            }
            StarRatingBar(rating = review.nota, onRatingChanged = {}, editable = false, modifier = Modifier.padding(vertical = 4.dp))
            if (review.comentario.isNotBlank()) {
                Text(review.comentario, style = MaterialTheme.typography.bodyMedium, color = BrownTextLight)
            }
        }
    }
}
