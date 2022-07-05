package io.github.ilyaskerbal.tracker_presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.tracker_presentation.components.NutrientsHeader
import io.github.ilyaskerbal.tracker_presentation.tracker_overview.TrackerOverviewViewModel

@Composable
fun TrackerOverviewScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader(state = state)
        }
    }
}