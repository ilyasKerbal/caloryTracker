package io.github.ilyaskerbal.onboarding_presentation.gender

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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core.domain.model.Gender
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.core_ui.theme.CaloryTrackerTheme
import io.github.ilyaskerbal.onboarding_presentation.components.ActionButton
import io.github.ilyaskerbal.onboarding_presentation.components.SelectableButton

@Composable
fun GenderScreen(
    onNextClick: () -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
){
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UIEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }

    GenderScreenContent(
        currentGender = viewModel.selectedGender,
        onMaleSelected = { viewModel.onGenderClick(Gender.Male) },
        onFemaleSelected = { viewModel.onGenderClick(Gender.Female) },
        onNext = viewModel::onNextClick
    )
}

@Composable
private fun GenderScreenContent(
    currentGender: Gender,
    onMaleSelected: () -> Unit,
    onFemaleSelected: () -> Unit,
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
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.male),
                    isSelected = currentGender is Gender.Male,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = onMaleSelected
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.female),
                    isSelected = currentGender is Gender.Female,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = onFemaleSelected
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
private fun PreviewGenderScreen() {
    CaloryTrackerTheme {
        GenderScreenContent(
            currentGender = Gender.Male,
            onMaleSelected = {},
            onFemaleSelected = {},
            onNext = {}
        )
    }
}