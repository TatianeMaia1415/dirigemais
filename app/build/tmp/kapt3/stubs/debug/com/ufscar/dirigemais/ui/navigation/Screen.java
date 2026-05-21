package com.ufscar.dirigemais.ui.navigation;

/**
 * Rotas de navegação do app — apenas as 5 telas necessárias.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Favorites", "InstructorDetail", "Login", "Register", "Splash", "StudentHome", "Lcom/ufscar/dirigemais/ui/navigation/Screen$Favorites;", "Lcom/ufscar/dirigemais/ui/navigation/Screen$InstructorDetail;", "Lcom/ufscar/dirigemais/ui/navigation/Screen$Login;", "Lcom/ufscar/dirigemais/ui/navigation/Screen$Register;", "Lcom/ufscar/dirigemais/ui/navigation/Screen$Splash;", "Lcom/ufscar/dirigemais/ui/navigation/Screen$StudentHome;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$Favorites;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Favorites extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.Favorites INSTANCE = null;
        
        private Favorites() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$InstructorDetail;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "createRoute", "", "id", "app_debug"})
    public static final class InstructorDetail extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.InstructorDetail INSTANCE = null;
        
        private InstructorDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$Login;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Login extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$Register;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Register extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.Register INSTANCE = null;
        
        private Register() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$Splash;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Splash extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ufscar/dirigemais/ui/navigation/Screen$StudentHome;", "Lcom/ufscar/dirigemais/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class StudentHome extends com.ufscar.dirigemais.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.ufscar.dirigemais.ui.navigation.Screen.StudentHome INSTANCE = null;
        
        private StudentHome() {
        }
    }
}