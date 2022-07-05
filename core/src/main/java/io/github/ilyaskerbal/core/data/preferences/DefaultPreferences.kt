package io.github.ilyaskerbal.core.data.preferences

import android.content.SharedPreferences
import io.github.ilyaskerbal.core.domain.model.ActivityLevel
import io.github.ilyaskerbal.core.domain.model.Gender
import io.github.ilyaskerbal.core.domain.model.GoalType
import io.github.ilyaskerbal.core.domain.model.UserInfo
import io.github.ilyaskerbal.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref : SharedPreferences
) : Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, type.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_ONBOARDING,
            true
        )
    }

    override fun loadUserInfo(): UserInfo {
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, null) ?: "Female"
        val ageInt = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val weightFloat = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val heightInt = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null) ?: "low"
        val goalTypeString = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null) ?: "lose_weight"
        val carbRatioFloat = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatioFloat = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatioFloat = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString),
            age = ageInt,
            weight = weightFloat,
            height = heightInt,
            activityLevel = ActivityLevel.fromString(activityLevelString),
            goalType = GoalType.fromString(goalTypeString),
            carbRatio = carbRatioFloat,
            proteinRatio = proteinRatioFloat,
            fatRatio = fatRatioFloat
        )
    }
}