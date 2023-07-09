package io.spherelabs.cosmo.onboarding

import io.spherelabs.meteor.configs.MeteorConfigs
import io.spherelabs.meteor.store.Store
import io.spherelabs.meteor.viewmodel.CommonViewModel
import io.spherelabs.meteor.viewmodel.createMeteor
import io.spherelabs.meteorviewmodel.commonflow.NonNullCommonFlow
import io.spherelabs.meteorviewmodel.commonflow.NonNullCommonStateFlow
import io.spherelabs.meteorviewmodel.commonflow.asCommonFlow
import io.spherelabs.meteorviewmodel.commonflow.asCommonStateFlow
import io.spherelabs.features.OnboardingEffect
import io.spherelabs.features.OnboardingMiddleware
import io.spherelabs.features.OnboardingReducer
import io.spherelabs.features.OnboardingState
import io.spherelabs.features.OnboardingWish

class OnboardingViewModel(
    private val onboardingReducer: OnboardingReducer,
    private val onboardingMiddleware: OnboardingMiddleware
) : CommonViewModel<OnboardingState, OnboardingWish, OnboardingEffect>() {

    override val store: Store<OnboardingState, OnboardingWish, OnboardingEffect> = createMeteor(
        configs = MeteorConfigs.build {
            initialState = OnboardingState.Empty
            storeName = "OnboardingViewModel"
            reducer = onboardingReducer
            middlewares = listOf(onboardingMiddleware)
        }
    )

    val effect: NonNullCommonFlow<OnboardingEffect> = store.effect.asCommonFlow()
    val state: NonNullCommonStateFlow<OnboardingState> = store.state.asCommonStateFlow()

}