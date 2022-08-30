package io.github.ilyaskerbal.tracker_presentation.search

import io.github.ilyaskerbal.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)