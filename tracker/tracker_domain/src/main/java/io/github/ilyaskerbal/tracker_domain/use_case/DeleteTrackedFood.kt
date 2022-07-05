package io.github.ilyaskerbal.tracker_domain.use_case

import io.github.ilyaskerbal.tracker_domain.model.TrackedFood
import io.github.ilyaskerbal.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}