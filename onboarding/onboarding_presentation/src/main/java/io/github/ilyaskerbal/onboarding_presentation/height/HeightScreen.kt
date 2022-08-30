package io.github.ilyaskerbal.onboarding_presentation.height

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core_ui.theme.CaloryTrackerTheme
import io.github.ilyaskerbal.onboarding_presentation.components.ActionButton
import io.github.ilyaskerbal.onboarding_presentation.components.UnitTextField

@Composable
fun HeightScreen(
    scaffoldState: ScaffoldState,
    onNextClick: () -> Unit,
    viewModel: HeightViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Success -> onNextClick()
                is UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                else -> Unit
            }
        }
    }

    HeightScreenContent(
        height = viewModel.height,
        onHeightChange = viewModel::onHeightEnter,
        onNext = viewModel::onNextClick
    )
}

@Composable
private fun HeightScreenContent(
    height: String,
    onHeightChange: (String) -> Unit,
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
                text = stringResource(id = R.string.whats_your_height),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = height,
                onValueChange = onHeightChange,
                unit = stringResource(id = R.string.cm)
            )
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
private fun PreviewHeightScreen() {
    CaloryTrackerTheme {
        HeightScreenContent(height = "190", onHeightChange = {}, onNext = {})
    }
}