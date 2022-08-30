package io.github.ilyaskerbal.tracker_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.tracker_presentation.components.DaySelector
import io.github.ilyaskerbal.tracker_presentation.components.ExpandableMeal
import io.github.ilyaskerbal.tracker_presentation.components.NutrientsHeader
import io.github.ilyaskerbal.tracker_presentation.tracker_overview.Meal
import io.github.ilyaskerbal.tracker_presentation.tracker_overview.TrackerOverviewEvent
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
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            DaySelector(
                date = state.date,
                onPreviousDayClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick)
                },
                onNextDayClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
        items(state.meals) { item: Meal ->
            ExpandableMeal(
                meal = item,
                onToggleClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(item))
                },
                content = {

                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}