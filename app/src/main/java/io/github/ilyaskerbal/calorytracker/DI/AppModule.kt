package io.github.ilyaskerbal.calorytracker.DI

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ilyaskerbal.core.data.preferences.DefaultPreferences
import io.github.ilyaskerbal.core.domain.preferences.Preferences
import io.github.ilyaskerbal.core.domain.use_case.FilterOutDigits
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ) : SharedPreferences = app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePreferences(
        sharedPreferences: SharedPreferences
    ) : Preferences = DefaultPreferences(sharedPreferences)

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase() : FilterOutDigits {
        return FilterOutDigits()
    }

}