package io.github.ilyaskerbal.tracker_data.remote.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.ilyaskerbal.tracker_data.remote.local.entity.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {

    abstract val dao: TrackerDao
}