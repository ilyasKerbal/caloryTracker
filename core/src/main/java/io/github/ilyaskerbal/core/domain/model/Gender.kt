package io.github.ilyaskerbal.core.domain.model

sealed class Gender(val name: String) {
    object Male : Gender("Male")
    object Female : Gender("Female")

    companion object {
        fun fromString(type: String) : Gender = when(type) {
            "Male" -> Male
            "Female" -> Female
            else -> Female
        }
    }
}
