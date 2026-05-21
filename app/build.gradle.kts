plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt") // Necessário para o Room gerar código automaticamente
}

android {
    namespace = "com.ufscar.dirigemais"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ufscar.dirigemais"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions { jvmTarget = "1.8" }

    buildFeatures { compose = true }

    composeOptions { kotlinCompilerExtensionVersion = "1.5.10" }

    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies {
    // --- Core Android ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // --- Jetpack Compose (via BOM — garante versões compatíveis) ---
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Ícones extras do Material (ex: Star, Favorite, WhatsApp shape)
    implementation("androidx.compose.material:material-icons-extended:1.6.8")

    // --- Navegação entre telas (Navigation Compose) ---
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // --- ViewModel integrado com Compose ---
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")

    // --- Room (banco de dados local SQLite) ---
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")       // suporte a coroutines no Room
    kapt("androidx.room:room-compiler:2.6.1")            // gerador de código do Room

    // --- Retrofit (requisições HTTP para a API REST) ---
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // converte JSON <-> Kotlin
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0") // log de requisições (debug)

    // ⚠️ FORA DO MATERIAL DE AULA: Coil — carregamento de imagens via URL em Compose
    // (O material usa Glide, mas Glide não tem suporte nativo a Compose; Coil é o equivalente)
    implementation("io.coil-kt:coil-compose:2.6.0")

    // --- Testes Unitários ---
    testImplementation(libs.junit)
    testImplementation("org.mockito:mockito-core:5.5.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("androidx.arch.core:core-testing:2.2.0") // InstantTaskExecutorRule

    // --- Testes Instrumentados (rodam no device/emulador) ---
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
