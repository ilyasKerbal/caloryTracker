package io.github.ilyaskerbal.onboarding_presentation.activity

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.domain.model.ActivityLevel
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.onboarding_presentation.components.ActionButton
import io.github.ilyaskerbal.onboarding_presentation.components.SelectableButton
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core_ui.theme.CaloryTrackerTheme

@Composable
fun ActivityScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    ActivityScreenContent(
        selectedLevel = viewModel.selectedActivityLevel,
        onActivitySelected = viewModel::onActivityLevelSelect,
        onNext = viewModel::onNextClick
    )
}

@Composable
private fun ActivityScreenContent(
    selectedLevel: ActivityLevel,
    onActivitySelected: (ActivityLevel) -> Unit,
    onNext: () -> Unit
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_activity_level),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.low),
                    isSelected = selectedLevel is ActivityLevel.Low,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        onActivitySelected(ActivityLevel.Low)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.medium),
                    isSelected = selectedLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        onActivitySelected(ActivityLevel.Medium)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.high),
                    isSelected = selectedLevel is ActivityLevel.High,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        onActivitySelected(ActivityLevel.High)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = onNext,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(
    name = "Light Theme",
    device = Devices.PIXEL_2,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
private fun PreviewActivityScreen() {
    CaloryTrackerTheme {
        ActivityScreenContent(
            selectedLevel = ActivityLevel.Medium,
            onActivitySelected = {},
            onNext = {}
        )
    }
}