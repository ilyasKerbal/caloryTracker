package io.github.ilyaskerbal.core.util

sealed class UIEvent {
    //data class Navigate(val route: String) : UIEvent()
    object Success: UIEvent()
    object NavigateUp: UIEvent()
    data class ShowSnackbar(val message: UIText) : UIEvent()
}
