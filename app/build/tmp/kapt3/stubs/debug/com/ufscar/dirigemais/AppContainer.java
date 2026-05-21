package com.ufscar.dirigemais;

/**
 * AppContainer = "caixa de dependências" manual.
 *
 * Como não usamos Hilt (injeção de dependência automática), criamos as
 * instâncias aqui e as passamos manualmente para quem precisar.
 *
 * ⚠️ FORA DO MATERIAL: Hilt/Dagger são as ferramentas padrão para DI em Android,
 *   mas não foram cobertos nas aulas. Este container manual cumpre a mesma função.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/ufscar/dirigemais/AppContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/ufscar/dirigemais/data/local/AppDatabase;", "instructorRepository", "Lcom/ufscar/dirigemais/data/repository/InstructorRepository;", "getInstructorRepository", "()Lcom/ufscar/dirigemais/data/repository/InstructorRepository;", "sessionManager", "Lcom/ufscar/dirigemais/data/local/SessionManager;", "getSessionManager", "()Lcom/ufscar/dirigemais/data/local/SessionManager;", "userRepository", "Lcom/ufscar/dirigemais/data/repository/UserRepository;", "getUserRepository", "()Lcom/ufscar/dirigemais/data/repository/UserRepository;", "app_debug"})
public final class AppContainer {
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.local.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.local.SessionManager sessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.repository.InstructorRepository instructorRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.repository.UserRepository userRepository = null;
    
    public AppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ufscar.dirigemais.data.local.SessionManager getSessionManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ufscar.dirigemais.data.repository.InstructorRepository getInstructorRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ufscar.dirigemais.data.repository.UserRepository getUserRepository() {
        return null;
    }
}