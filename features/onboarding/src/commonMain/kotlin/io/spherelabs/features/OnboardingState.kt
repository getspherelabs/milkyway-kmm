package io.spherelabs.features

data class OnboardingState(
    val name: String = ""
) {
    companion object {
        val Empty = OnboardingState()
    }
}
