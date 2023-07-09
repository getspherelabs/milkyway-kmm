package io.spherelabs.features

sealed interface OnboardingWish {
    object GetStarted: OnboardingWish
    object AlreadyHaveAccount: OnboardingWish
}