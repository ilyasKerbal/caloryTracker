package io.github.ilyaskerbal.tracker_presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.core_ui.theme.*

@Composable
fun NutrientsBar(
    carbs: Int,
    protein: Int,
    fat: Int,
    calories: Int,
    calorieGoal: Int,
    modifier: Modifier = Modifier
) {
    val background = MaterialTheme.colors.background
    val caloriesExceedColor = MaterialTheme.colors.error
    val carbWidthRatio = remember {
        Animatable(0f)
    }
    val proteinWidthRatio = remember {
        Animatable(0f)
    }
    val fatWidthRatio = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = carbs) {
        carbWidthRatio.animateTo(
            targetValue = ((carbs * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(key1 = protein) {
        proteinWidthRatio.animateTo(
            targetValue = ((protein * 4f) / calorieGoal)
        )
    }
    LaunchedEffect(key1 = fat) {
        fatWidthRatio.animateTo(
            targetValue = ((fat * 9f) / calorieGoal)
        )
    }
    Canvas(modifier = modifier) {
        if(calories <= calorieGoal) {
            val carbsWidth = carbWidthRatio.value * size.width
            val proteinWidth = proteinWidthRatio.value * size.width
            val fatWidth = fatWidthRatio.value * size.width
            drawRoundRect(
                color = background,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = FatColor,
                size = Size(
                    width = carbsWidth + proteinWidth + fatWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = ProteinColor,
                size = Size(
                    width = carbsWidth + proteinWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                color = CarbColor,
                size = Size(
                    width = carbsWidth,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f)
            )
        } else {
            drawRoundRect(
                color = caloriesExceedColor,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
        }
    }
}

@Preview(
    name = "Empty",
    showBackground = true,
    widthDp = 200,
    heightDp = 30,
    backgroundColor = 0xFF00C713
)
@Composable
private fun PreviewNutrientsBarEmpty() {
    CaloryTrackerTheme {
        NutrientsBar(carbs = 0, protein = 0, fat = 0, calories = 0, calorieGoal = 2000)
    }
}

@Preview(
    name = "Full",
    showBackground = true,
    widthDp = 200,
    heightDp = 30,
    backgroundColor = 0xFF00C713
)
@Composable
private fun PreviewNutrientsBar() {
    CaloryTrackerTheme {
        NutrientsBar(carbs = 150, protein = 30, fat = 45, calories = 1500, calorieGoal = 2000)
    }
}

@Preview(
    name = "Calories exceeded",
    showBackground = true,
    widthDp = 200,
    heightDp = 30,
    backgroundColor = 0xFF00C713
)
@Composable
private fun PreviewNutrientsBarExceed() {
    CaloryTrackerTheme {
        NutrientsBar(carbs = 250, protein = 60, fat = 55, calories = 2500, calorieGoal = 2000)
    }
}