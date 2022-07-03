package io.github.ilyaskerbal.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core.domain.preferences.Preferences
import io.github.ilyaskerbal.core.navigation.Route
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core.util.UIText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences,
): ViewModel() {

    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String) {
        if(weight.length <= 5) {
            this.weight = weight
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val weightNumber = weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UIEvent.ShowSnackbar(
                        UIText.StringResource(R.string.error_weight_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveWeight(weightNumber)
            _uiEvent.send(UIEvent.Navigate(Route.ACTIVITY))
        }
    }
}