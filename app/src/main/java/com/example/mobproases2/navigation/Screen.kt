package com.example.mobproases2.navigation

import com.example.mobproases2.ui.screen.KEY_ID_BUNGA

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_BUNGA}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}