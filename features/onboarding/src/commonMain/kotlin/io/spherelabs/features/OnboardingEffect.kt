package io.spherelabs.features

sealed interface OnboardingEffect {
    object SignIn : OnboardingEffect
    object SignUp : OnboardingEffect
    data class Failure(val msg: String) : OnboardingEffect
}