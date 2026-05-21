package com.ufscar.dirigemais.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001aN\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001aB\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u000fH\u0007\u00a8\u0006\u001a"}, d2 = {"FavoriteCard", "", "favorite", "Lcom/ufscar/dirigemais/data/local/entity/FavoriteEntity;", "onClick", "Lkotlin/Function0;", "onRemove", "modifier", "Landroidx/compose/ui/Modifier;", "InstructorCard", "instructor", "Lcom/ufscar/dirigemais/data/remote/dto/InstructorDto;", "onFavoriteClick", "onWhatsappClick", "isFavorite", "", "ReviewCard", "review", "Lcom/ufscar/dirigemais/data/remote/dto/ReviewDto;", "StarRatingBar", "rating", "", "onRatingChanged", "Lkotlin/Function1;", "maxStars", "editable", "app_debug"})
public final class ComponentsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void InstructorCard(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.InstructorDto instructor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFavoriteClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onWhatsappClick, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FavoriteCard(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.local.entity.FavoriteEntity favorite, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRemove, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StarRatingBar(int rating, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRatingChanged, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, int maxStars, boolean editable) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ReviewCard(@org.jetbrains.annotations.NotNull()
    com.ufscar.dirigemais.data.remote.dto.ReviewDto review, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}