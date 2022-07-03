package io.github.ilyaskerbal.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ilyaskerbal.core.domain.model.Gender
import io.github.ilyaskerbal.core.domain.preferences.Preferences
import io.github.ilyaskerbal.core.navigation.Route
import io.github.ilyaskerbal.core.util.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _uiEvents = Channel<UIEvent>()
    val uiEvent = _uiEvents.receiveAsFlow() // Flow<UIEvent>

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiEvents.send(UIEvent.Navigate(Route.AGE))
        }
    }
}