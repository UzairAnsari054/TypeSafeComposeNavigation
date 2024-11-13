package com.example.typesavecomposenavigation

sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object Screen1 : Screen

    @kotlinx.serialization.Serializable
    data class Screen2 (val num: Int) : Screen

    @kotlinx.serialization.Serializable
    data object Screen3 : Screen
}