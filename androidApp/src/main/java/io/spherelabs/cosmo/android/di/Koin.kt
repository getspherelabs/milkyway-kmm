package io.spherelabs.cosmo.android.di

import io.spherelabs.cosmo.onboarding.OnboardingViewModel
import io.spherelabs.cosmo.auth.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::SignUpViewModel)
}