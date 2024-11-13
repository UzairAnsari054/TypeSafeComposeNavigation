package com.example.typesavecomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.typesavecomposenavigation.ui.theme.TypeSaveComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSaveComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Screen1,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } }
    ) {
        composable<Screen.Screen1> {
            Screen1(
                onNavigateToNextScreen = {
                    navController.navigate(Screen.Screen2(num = 12))
                }
            )
        }

        composable<Screen.Screen2> { backStackEntry ->
            val screen2 = backStackEntry.toRoute<Screen.Screen2>()
            Screen2(
                num = screen2.num,
                onNavigateToNextScreen = {
                    navController.popBackStack()
                    navController.navigate(Screen.Screen3)
                }
            )
        }

        composable<Screen.Screen3> {
            Screen3(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}