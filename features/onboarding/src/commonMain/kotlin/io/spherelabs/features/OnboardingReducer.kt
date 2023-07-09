package io.spherelabs.features

import io.spherelabs.meteor.configs.Change
import io.spherelabs.meteor.extension.route
import io.spherelabs.meteor.reducer.Reducer

class OnboardingReducer : Reducer<OnboardingState, OnboardingWish, OnboardingEffect> {

    override fun reduce(
        state: OnboardingState,
        wish: OnboardingWish
    ): Change<OnboardingState, OnboardingEffect> {
        return when (wish) {
            OnboardingWish.AlreadyHaveAccount -> {
                route {
                    OnboardingEffect.SignIn
                }
            }

            OnboardingWish.GetStarted -> {
                route {
                    OnboardingEffect.SignUp
                }
            }
        }
    }
}