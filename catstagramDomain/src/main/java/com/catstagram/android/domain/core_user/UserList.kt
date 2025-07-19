package com.catstagram.android.domain.core_user

import androidx.annotation.DrawableRes
import com.example.catstagramdomain.R

data class User(
    val id: Int = -1,
    val name: String = "",
    @DrawableRes val icon: Int = -1,
)

val userList = listOf(
    User(0, "You", R.drawable.maxresdefault),
    User(1, "Marat_WarTHUNDER", R.drawable._22),
    User(2, "Leha", R.drawable.__2025_06_29_103259),
    User(3, "Albertina_Iglesias", R.drawable.__2025_06_29_115926),
    User(4, "Masha228", R.drawable.photo_icon),
    User(5, "Pasha007", R.drawable.photo_icon),
    User(6, "ABCDEFGJKKK", R.drawable.photo_icon)
)

val userListPlaceHolder = listOf(
    User(0, "You", R.drawable.usericon_placeholder),
    User(1, "", R.drawable.usericon_placeholder),
    User(2, "", R.drawable.usericon_placeholder),
)