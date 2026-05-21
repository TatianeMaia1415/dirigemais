package com.ufscar.dirigemais.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ufscar.dirigemais.R
import com.ufscar.dirigemais.ui.theme.*

/**
 * Tela 2a — Login
 * Fiel ao protótipo Figma:
 * - Cabeçalho verde-menta com círculos decorativos
 * - Toggle "você é: Aluno | Instrutor(a)" com âmbar para selecionado
 * - Campos de e-mail e senha no card branco
 * - Botão "Entrar" âmbar, "Criar nova conta" outlined verde
 */
@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: (tipo: String) -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var email        by remember { mutableStateOf("") }
    var senha        by remember { mutableStateOf("") }
    var senhaVisible by remember { mutableStateOf(false) }
    var tipoSelecionado by remember { mutableStateOf("aluno") }

    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthViewModel.AuthState.LoginSuccess) {
            onLoginSuccess((authState as AuthViewModel.AuthState.LoginSuccess).tipo)
            viewModel.resetState()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // ---- Cabeçalho verde-menta com círculos decorativos (como no Figma) ----
        Box(
            modifier         = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.radialGradient(
                        colors  = listOf(MintGreen, Color(0xFFCBE9E0)),
                        radius  = 600f
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            // Círculos decorativos nos cantos (exatamente como no Figma)
            Box(
                modifier = Modifier
                    .offset(x = (-80).dp, y = (-30).dp)
                    .size(140.dp)
                    .background(DarkGreen.copy(alpha = 0.25f), CircleShape)
            )
            Box(
                modifier = Modifier
                    .offset(x = 90.dp, y = (-20).dp)
                    .size(100.dp)
                    .background(DarkGreen.copy(alpha = 0.20f), CircleShape)
                    .align(Alignment.TopEnd)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text       = "Bem-vindo(a)!",
                    fontSize   = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color      = BrownText
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text  = "Acesse ou crie sua conta",
                    color = BrownTextLight,
                    fontSize = 15.sp
                )
            }
        }

        // ---- Card branco com o formulário ----
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Toggle "você é: Aluno | Instrutor(a)"
            Text(
                text       = "você é:",
                fontWeight = FontWeight.Bold,
                color      = BrownText,
                fontSize   = 16.sp
            )
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                listOf("aluno" to "Aluno", "instrutor" to "Instrutor(a)").forEach { (value, label) ->
                    val isSelected = tipoSelecionado == value
                    Button(
                        onClick  = { tipoSelecionado = value },
                        colors   = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) Amber else androidx.compose.ui.graphics.Color.Transparent,
                            contentColor   = if (isSelected) BrownText else BrownTextLight
                        ),
                        elevation = ButtonDefaults.buttonElevation(if (isSelected) 2.dp else 0.dp),
                        shape    = RoundedCornerShape(50.dp),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Text(label, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // Campo E-mail
            Text(
                text     = stringResource(R.string.email_label),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                color    = BrownText
            )
            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                value           = email,
                onValueChange   = { email = it },
                placeholder     = { Text("seu@email.com", color = GrayMedium) },
                singleLine      = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier        = Modifier.fillMaxWidth(),
                shape           = RoundedCornerShape(12.dp),
                colors          = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = GrayField,
                    focusedContainerColor   = GrayField,
                    unfocusedBorderColor    = GrayField,
                    focusedBorderColor      = DarkGreen
                )
            )

            Spacer(Modifier.height(16.dp))

            // Campo Senha
            Text(
                text     = stringResource(R.string.password_label),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                color    = BrownText
            )
            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                value                = senha,
                onValueChange        = { senha = it },
                placeholder          = { Text("••••••••••", color = GrayMedium) },
                singleLine           = true,
                visualTransformation = if (senhaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions      = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon         = {
                    IconButton(onClick = { senhaVisible = !senhaVisible }) {
                        Icon(
                            if (senhaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            null, tint = GrayMedium
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape    = RoundedCornerShape(12.dp),
                colors   = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = GrayField,
                    focusedContainerColor   = GrayField,
                    unfocusedBorderColor    = GrayField,
                    focusedBorderColor      = DarkGreen
                )
            )

            // "Esqueceu a senha?"
            Box(modifier = Modifier.fillMaxWidth()) {
                TextButton(
                    onClick  = {},
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(stringResource(R.string.forgot_password), color = DarkGreen, fontSize = 13.sp)
                }
            }

            Spacer(Modifier.height(8.dp))

            // Erro
            if (authState is AuthViewModel.AuthState.Error) {
                Text(
                    text    = (authState as AuthViewModel.AuthState.Error).message,
                    color   = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier  = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
            }

            // Botão ENTRAR — âmbar, texto marrom bold (exatamente como no Figma)
            Button(
                onClick  = { viewModel.login(email, senha, tipoSelecionado) },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape    = RoundedCornerShape(50.dp),
                colors   = ButtonDefaults.buttonColors(containerColor = Amber, contentColor = BrownText),
                enabled  = authState !is AuthViewModel.AuthState.Loading
            ) {
                if (authState is AuthViewModel.AuthState.Loading) {
                    CircularProgressIndicator(Modifier.size(20.dp), color = BrownText)
                } else {
                    Text(stringResource(R.string.login_button), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Divisor "ou"
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = GrayBorder)
                Text(stringResource(R.string.or_divider), color = GrayMedium, fontSize = 13.sp)
                HorizontalDivider(modifier = Modifier.weight(1f), color = GrayBorder)
            }

            Spacer(Modifier.height(12.dp))

            // Botão "Criar nova conta" — outlined verde (como no Figma)
            OutlinedButton(
                onClick  = onNavigateToRegister,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape    = RoundedCornerShape(50.dp),
                colors   = ButtonDefaults.outlinedButtonColors(contentColor = DarkGreen),
                border   = ButtonDefaults.outlinedButtonBorder.copy(
                    width = 1.5.dp
                )
            ) {
                Text(stringResource(R.string.register_link), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text     = stringResource(R.string.terms_of_use),
                color    = GrayMedium,
                fontSize = 11.sp,
                textAlign = TextAlign.Center,
                modifier  = Modifier.fillMaxWidth()
            )
        }
    }
}
