package com.ufscar.dirigemais.ui.screens.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ufscar.dirigemais.ui.theme.*
import kotlinx.coroutines.delay

/**
 * Tela 1 — Onboarding / Splash
 * Fiel ao protótipo Figma: fundo verde-menta, logo "Dirige+", seta âmbar.
 */
@Composable
fun SplashScreen(onSplashFinished: (Boolean, String) -> Unit) {

    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.85f) }
    var showButton by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Animação de entrada
        alpha.animateTo(1f, animationSpec = tween(800))
        scale.animateTo(1f, animationSpec = spring(Spring.DampingRatioMediumBouncy))
        delay(400)
        showButton = true
    }

    Box(
        modifier         = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors     = listOf(MintGreen, Color(0xFFD4EDE6)),
                    startY     = 0f,
                    endY       = Float.POSITIVE_INFINITY
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Nuvens decorativas (círculos verdes, como no Figma)
        Box(
            modifier = Modifier
                .offset(x = (-80).dp, y = (-260).dp)
                .size(90.dp)
                .background(DarkGreen.copy(alpha = 0.35f), CircleShape)
        )
        Box(
            modifier = Modifier
                .offset(x = 90.dp, y = (-290).dp)
                .size(60.dp)
                .background(DarkGreen.copy(alpha = 0.25f), CircleShape)
        )
        Box(
            modifier = Modifier
                .offset(x = (-130).dp, y = (-200).dp)
                .size(50.dp)
                .background(DarkGreen.copy(alpha = 0.20f), CircleShape)
        )

        // Conteúdo central
        Column(
            modifier            = Modifier
                .fillMaxWidth()
                .scale(scale.value)
                .alpha(alpha.value),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícone de carro (representado com emoji-like box)
            Box(
                modifier         = Modifier
                    .size(180.dp)
                    .background(DarkGreen.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("🚗", fontSize = 72.sp)
            }

            Spacer(Modifier.height(32.dp))

            // Nome do app
            Text(
                text       = "Dirige+",
                fontSize   = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color      = BrownText
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text      = "Aprender a dirigir nunca\nficou tão fácil",
                fontSize  = 16.sp,
                color     = BrownTextLight,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )
        }

        // Botão de seta âmbar (canto inferior direito, como no Figma)
        if (showButton) {
            Box(
                modifier         = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 40.dp, bottom = 80.dp),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick          = { onSplashFinished(false, "") },
                    containerColor   = Amber,
                    contentColor     = BrownText,
                    shape            = CircleShape,
                    modifier         = Modifier.size(56.dp)
                ) {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "Avançar")
                }
            }
        }

        // Indicadores de página (dots inferiores, como no Figma)
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(Modifier.size(width = 24.dp, height = 4.dp).background(DarkGreen, RoundedCornerShape(2.dp)))
            Box(Modifier.size(width = 16.dp, height = 4.dp).background(DarkGreen.copy(alpha = 0.3f), RoundedCornerShape(2.dp)))
        }
    }
}
