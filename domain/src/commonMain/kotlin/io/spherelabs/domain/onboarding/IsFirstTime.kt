package io.spherelabs.domain.onboarding

import io.spherelabs.setting.onboarding.OnboardingSetting

interface IsFirstTime {
    suspend fun execute(): Boolean
}

class DefaultIsFirstTime(
    private val onboardingSetting: OnboardingSetting
) : IsFirstTime {
    override suspend fun execute(): Boolean {
        return onboardingSetting.isFirstTime()
    }
}