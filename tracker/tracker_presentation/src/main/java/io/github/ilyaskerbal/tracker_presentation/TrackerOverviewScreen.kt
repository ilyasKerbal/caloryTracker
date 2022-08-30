package io.github.ilyaskerbal.tracker_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.tracker_presentation.components.*
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
                      Column(
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(horizontal = spacing.spaceSmall)
                      ) {
                          state.trackedFoods.forEach { trackedFood ->
                              TrackedFoodItem(
                                  trackedFood = trackedFood,
                                  onDeleteClick = {
                                      viewModel.onEvent(
                                          TrackerOverviewEvent
                                              .OnDeleteTrackedFoodClick(trackedFood)
                                      )
                                  }
                              )
                              Spacer(modifier = Modifier.height(spacing.spaceMedium))
                          }
                          AddButton(
                              text = stringResource(
                                  id = R.string.add_meal,
                                  item.name.asString(context)
                              ),
                              onClick = {
                                  viewModel.onEvent(
                                      TrackerOverviewEvent.OnAddFoodClick(item)
                                  )
                              },
                              modifier = Modifier.fillMaxWidth()
                          )
                      }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}