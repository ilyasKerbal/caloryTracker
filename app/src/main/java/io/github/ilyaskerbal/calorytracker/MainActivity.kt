package io.github.ilyaskerbal.calorytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.ilyaskerbal.calorytracker.navigation.navigate
import io.github.ilyaskerbal.calorytracker.ui.theme.CaloryTrackerTheme
import io.github.ilyaskerbal.core.navigation.Route
import io.github.ilyaskerbal.onboarding_presentation.activity.ActivityScreen
import io.github.ilyaskerbal.onboarding_presentation.age.AgeScreen
import io.github.ilyaskerbal.onboarding_presentation.gender.GenderScreen
import io.github.ilyaskerbal.onboarding_presentation.goal.GoalScreen
import io.github.ilyaskerbal.onboarding_presentation.height.HeightScreen
import io.github.ilyaskerbal.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import io.github.ilyaskerbal.onboarding_presentation.weight.WeightScreen
import io.github.ilyaskerbal.onboarding_presentation.welcome.WelcomeScreen
import io.github.ilyaskerbal.tracker_presentation.TrackerOverviewScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ){ padding ->
                    NavHost(
                        modifier = Modifier.padding(padding),
                        navController = navController,
                        startDestination = Route.WELCOME
                    ) {
                        composable(Route.WELCOME){
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE){
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.GENDER){
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.HEIGHT){
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.WEIGHT){
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.NUTRIENT_GOAL){
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.ACTIVITY){
                            ActivityScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GOAL){
                            GoalScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.TRACKER_OVERVIEW){
                            TrackerOverviewScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.SEARCH){

                        }
                    }
                }
            }
        }
    }
}
