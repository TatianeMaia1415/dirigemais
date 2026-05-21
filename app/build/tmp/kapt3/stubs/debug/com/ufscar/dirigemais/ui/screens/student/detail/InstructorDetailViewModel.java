package com.ufscar.dirigemais.ui.screens.student.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/student/detail/InstructorDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ufscar/dirigemais/data/repository/InstructorRepository;", "(Lcom/ufscar/dirigemais/data/repository/InstructorRepository;)V", "_instructor", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ufscar/dirigemais/data/remote/NetworkResult;", "Lcom/ufscar/dirigemais/data/remote/dto/InstructorDto;", "_isFavorite", "", "_reviews", "", "Lcom/ufscar/dirigemais/data/remote/dto/ReviewDto;", "instructor", "Lkotlinx/coroutines/flow/StateFlow;", "getInstructor", "()Lkotlinx/coroutines/flow/StateFlow;", "isFavorite", "reviews", "getReviews", "loadInstructor", "", "id", "", "toggleFavorite", "Factory", "app_debug"})
public final class InstructorDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ufscar.dirigemais.data.repository.InstructorRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> _instructor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> instructor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<java.util.List<com.ufscar.dirigemais.data.remote.dto.ReviewDto>>> _reviews = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<java.util.List<com.ufscar.dirigemais.data.remote.dto.ReviewDto>>> reviews = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isFavorite = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite = null;
    
    public InstructorDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.repository.InstructorRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<com.ufscar.dirigemais.data.remote.dto.InstructorDto>> getInstructor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ufscar.dirigemais.data.remote.NetworkResult<java.util.List<com.ufscar.dirigemais.data.remote.dto.ReviewDto>>> getReviews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    public final void loadInstructor(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.InstructorDto instructor) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ufscar/dirigemais/ui/screens/student/detail/InstructorDetailViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repo", "Lcom/ufscar/dirigemais/data/repository/InstructorRepository;", "(Lcom/ufscar/dirigemais/data/repository/InstructorRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.ufscar.dirigemais.data.repository.InstructorRepository repo = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.ufscar.dirigemais.data.repository.InstructorRepository repo) {
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