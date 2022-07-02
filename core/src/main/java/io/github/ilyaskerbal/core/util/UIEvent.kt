package io.github.ilyaskerbal.core.util

sealed class UIEvent {
    data class Navigate(val route: String) : UIEvent()
    object NavigateUp: UIEvent()
}
