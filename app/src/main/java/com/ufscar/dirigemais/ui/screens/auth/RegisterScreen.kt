package com.ufscar.dirigemais.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ufscar.dirigemais.R

/**
 * Tela 2b — Cadastro
 * Usuário escolhe se é Aluno ou Instrutor antes de criar a conta.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    onRegisterSuccess: (tipo: String) -> Unit,
    onNavigateBack: () -> Unit
) {
    var nome   by remember { mutableStateOf("") }
    var email  by remember { mutableStateOf("") }
    var senha  by remember { mutableStateOf("") }
    var tipo   by remember { mutableStateOf("aluno") }

    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthViewModel.AuthState.RegisterSuccess) {
            onRegisterSuccess((authState as AuthViewModel.AuthState.RegisterSuccess).tipo)
            viewModel.resetState()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.register_title)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.nav_back))
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nome, onValueChange = { nome = it },
                label = { Text(stringResource(R.string.name_label)) },
                singleLine = true, modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(stringResource(R.string.email_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true, modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = senha, onValueChange = { senha = it },
                label = { Text(stringResource(R.string.password_label)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true, modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(20.dp))

            // Seleção de tipo de perfil
            Text(stringResource(R.string.profile_type_label), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                listOf("aluno" to R.string.profile_student, "instrutor" to R.string.profile_instructor).forEach { (value, labelRes) ->
                    FilterChip(
                        selected = tipo == value,
                        onClick  = { tipo = value },
                        label    = { Text(stringResource(labelRes)) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(Modifier.height(16.dp))

            if (authState is AuthViewModel.AuthState.Error) {
                Text(
                    text  = (authState as AuthViewModel.AuthState.Error).message,
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(Modifier.height(8.dp))
            }

            Button(
                onClick  = { viewModel.register(nome, email, senha, tipo) },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled  = authState !is AuthViewModel.AuthState.Loading
            ) {
                if (authState is AuthViewModel.AuthState.Loading) {
                    CircularProgressIndicator(Modifier.size(20.dp), color = MaterialTheme.colorScheme.onPrimary)
                } else {
                    Text(stringResource(R.string.register_button), fontSize = 16.sp)
                }
            }
            Spacer(Modifier.height(12.dp))
            TextButton(onClick = onNavigateBack) {
                Text(stringResource(R.string.already_have_account))
            }
        }
    }
}
