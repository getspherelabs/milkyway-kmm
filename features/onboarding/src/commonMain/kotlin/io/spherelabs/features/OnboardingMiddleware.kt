package io.spherelabs.features

import io.spherelabs.meteor.middleware.Middleware

class OnboardingMiddleware: Middleware<OnboardingState, OnboardingWish> {

    override suspend fun process(
        state: OnboardingState,
        wish: OnboardingWish,
        next: suspend (OnboardingWish) -> Unit
    ) {
        return when(wish) {
            OnboardingWish.AlreadyHaveAccount -> {
                /* no-op */
            }
            OnboardingWish.GetStarted -> {
                /* no-op */
            }
        }
    }
}