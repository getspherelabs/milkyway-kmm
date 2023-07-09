package io.spherelabs.cosmo.di

import io.spherelabs.auth.signup.SignUpMiddleware
import io.spherelabs.auth.signup.SignUpReducer
import io.spherelabs.auth.signup.ValidateMiddleware
import io.spherelabs.domain.di.domainModule
import io.spherelabs.features.OnboardingMiddleware
import io.spherelabs.features.OnboardingReducer
import io.spherelabs.firebaseauth.di.firebaseAuthModule
import io.spherelabs.setting.di.settingModule
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(declaration: KoinAppDeclaration = {}) =
    startKoin {
        declaration()

        modules(
            firebaseAuthModule,
            settingModule,
            domainModule,
            onboardingFeatureModule,
            signUpFeatureModule
        )
    }


val onboardingFeatureModule = module {
    single { OnboardingReducer() }
    single { OnboardingMiddleware() }
}

val signUpFeatureModule = module {
    single { SignUpReducer() }
    single { SignUpMiddleware(get()) }
    single { ValidateMiddleware(get(), get(), get()) }
}