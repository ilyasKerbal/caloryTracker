package io.github.ilyaskerbal.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.ilyaskerbal.calorytracker.navigation.navigate
import io.github.ilyaskerbal.calorytracker.ui.theme.CaloryTrackerTheme
import io.github.ilyaskerbal.core.navigation.Route
import io.github.ilyaskerbal.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME){
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE){

                    }
                    composable(Route.GENDER){

                    }
                    composable(Route.HEIGHT){

                    }
                    composable(Route.WEIGHT){

                    }
                    composable(Route.NUTRIENT_GOAL){

                    }
                    composable(Route.ACTIVITY){

                    }
                    composable(Route.GOAL){

                    }
                    composable(Route.TRACKER_OVERVIEW){

                    }
                    composable(Route.NUTRIENT_GOAL){

                    }
                }
            }
        }
    }
}
