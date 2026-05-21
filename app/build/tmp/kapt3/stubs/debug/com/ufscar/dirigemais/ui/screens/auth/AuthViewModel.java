package com.ufscar.dirigemais.ui.screens.auth;

/**
 * ViewModel de autenticação.
 *
 * ViewModel: sobrevive a mudanças de configuração (rotação da tela).
 * Nunca referencia Activity ou Context diretamente — evita memory leak.
 *
 * StateFlow: versão moderna do LiveData, mais integrada com Compose.
 * ⚠️ FORA DO MATERIAL: StateFlow (o material usa LiveData com Observers)
 *   Aqui usamos StateFlow porque é o padrão recomendado para Compose.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011J&\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/ufscar/dirigemais/data/repository/UserRepository;", "sessionManager", "Lcom/ufscar/dirigemais/data/local/SessionManager;", "(Lcom/ufscar/dirigemais/data/repository/UserRepository;Lcom/ufscar/dirigemais/data/local/SessionManager;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "login", "", "email", "", "senha", "tipoEscolhido", "register", "nome", "tipo", "resetState", "AuthState", "Factory", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.local.SessionManager sessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState> authState = null;
    
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.local.SessionManager sessionManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState> getAuthState() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String senha, @org.jetbrains.annotations.NotNull()
    java.lang.String tipoEscolhido) {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String senha, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo) {
    }
    
    public final void resetState() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "", "()V", "Error", "Idle", "Loading", "LoginSuccess", "RegisterSuccess", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Error;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Idle;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Loading;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$LoginSuccess;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$RegisterSuccess;", "app_debug"})
    public static abstract class AuthState {
        
        private AuthState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Error;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Idle;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "()V", "app_debug"})
        public static final class Idle extends com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            public static final com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$Loading;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "()V", "app_debug"})
        public static final class Loading extends com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            public static final com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$LoginSuccess;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "tipo", "", "(Ljava/lang/String;)V", "getTipo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class LoginSuccess extends com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String tipo = null;
            
            public LoginSuccess(@org.jetbrains.annotations.NotNull()
            java.lang.String tipo) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getTipo() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState.LoginSuccess copy(@org.jetbrains.annotations.NotNull()
            java.lang.String tipo) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState$RegisterSuccess;", "Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$AuthState;", "tipo", "", "(Ljava/lang/String;)V", "getTipo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class RegisterSuccess extends com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String tipo = null;
            
            public RegisterSuccess(@org.jetbrains.annotations.NotNull()
            java.lang.String tipo) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getTipo() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.ufscar.dirigemais.ui.screens.auth.AuthViewModel.AuthState.RegisterSuccess copy(@org.jetbrains.annotations.NotNull()
            java.lang.String tipo) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
    }
    
    /**
     * Factory necessária para passar dependências ao ViewModel sem Hilt
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/auth/AuthViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repo", "Lcom/ufscar/dirigemais/data/repository/UserRepository;", "session", "Lcom/ufscar/dirigemais/data/local/SessionManager;", "(Lcom/ufscar/dirigemais/data/repository/UserRepository;Lcom/ufscar/dirigemais/data/local/SessionManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.ufscar.dirigemais.data.repository.UserRepository repo = null;
        @org.jetbrains.annotations.NotNull()
        private final com.ufscar.dirigemais.data.local.SessionManager session = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.ufscar.dirigemais.data.repository.UserRepository repo, @org.jetbrains.annotations.NotNull()
        com.ufscar.dirigemais.data.local.SessionManager session) {
            super();
        }
        
        @java.lang.Override()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}