# Dirige+

Aplicativo Android nativo desenvolvido para a disciplina de Desenvolvimento Móvel (DC/UFSCar — 05/2026).

O Dirige+ conecta candidatos à CNH com instrutores autônomos credenciados pelo Detran, permitindo buscar por cidade/bairro, visualizar perfis completos, salvar favoritos e contatar via WhatsApp.

---

## Pré-requisitos

- Android Studio Hedgehog ou superior
- JDK 17
- Conexão com a internet (para sincronizar dependências e buscar dados da API)

---

## Como fazer o build

1. Clone ou descompacte o projeto
2. Abra o Android Studio → **File → Open** → selecione a pasta `DirigeMais/`
3. Aguarde o Gradle sync terminar (primeira vez pode levar alguns minutos)
4. Conecte um dispositivo físico ou inicie um emulador (API 24+)
5. Clique em **Run ▶** ou use `Shift + F10`

---

## Backend (MockAPI)

O app consome uma API REST simulada no MockAPI.io. A URL já está configurada no código:

```
https://6a0e2fb31736097c36099042.mockapi.io/api/v1/
```

Endpoints utilizados:

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/instrutores` | Lista todos os instrutores |
| GET | `/instrutores/{id}` | Busca instrutor por ID |
| GET | `/avaliacoes?instrutorId={id}` | Busca avaliações de um instrutor |

Não é necessário configurar nada — a URL já está pronta no `RetrofitClient.kt`.

---

## Como testar

### Fluxo principal

1. Abra o app → tela de Splash aparece
2. Clique na seta → tela de Login
3. Clique em **"Criar nova conta"** → preencha nome, e-mail e senha → **Criar Conta**
4. Home carrega os instrutores da API
5. Clique em um instrutor → veja os detalhes e avaliações
6. Clique no coração ♡ → instrutor salvo nos Favoritos
7. Aba **Favoritos** → instrutor aparece salvo localmente (Room)

### Testes automatizados

**Testes unitários** (rodam sem emulador):

```
No Android Studio:
Clique com botão direito em InstructorRepositoryTest.kt
→ Run 'InstructorRepositoryTest'
```

**Testes instrumentados** (precisam do emulador ligado):

```
No Android Studio:
Clique com botão direito em FavoriteDaoTest.kt
→ Run 'FavoriteDaoTest'
```

### Testando a internacionalização (R5)

No emulador:
**Settings → System → Languages → adiciona Português (Brasil) ou English (USA)**

Os textos da interface mudam automaticamente conforme o idioma do sistema.

---

## Arquitetura

O projeto segue o padrão **MVVM** com as seguintes camadas:

```
ui/          → Telas (Composables) e ViewModels
data/remote/ → API REST via Retrofit + DTOs
data/local/  → Banco local via Room (favoritos e sessão)
data/repository/ → Fonte única da verdade
```

---

## Tecnologias utilizadas

| Tecnologia | Uso |
|-----------|-----|
| Kotlin + Jetpack Compose | Linguagem e UI |
| Material Design 3 | Identidade visual |
| Retrofit + Gson | Consumo da API REST |
| Room (SQLite) | Persistência local |
| Coil | Carregamento de imagens |
| Navigation Compose | Navegação entre telas |
| JUnit 4 + Mockito | Testes automatizados |

---

## Requisitos atendidos

| Requisito | Status | Como verificar |
|-----------|--------|----------------|
| R1 — Identidade visual | ✅ | Abrir o app — paleta verde-menta, âmbar e marrom |
| R2 — Mínimo 3 telas | ✅ | 4 telas: Login, Home, Detalhes, Favoritos |
| R3 — Acesso à rede | ✅ | Home busca instrutores do MockAPI via Retrofit |
| R4 — Armazenamento local | ✅ | Favoritos salvos no Room — persistem após fechar o app |
| R5 — Internacionalização | ✅ | strings.xml em PT e EN — muda com idioma do sistema |
| R6 — MVVM + testes | ✅ | ViewModels, Repositories, InstructorRepositoryTest, FavoriteDaoTest |
