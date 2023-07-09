package io.spherelabs.domain.di

import io.spherelabs.domain.auth.CreateEmailAndPassword
import io.spherelabs.domain.auth.DefaultCreateEmailAndPassword
import io.spherelabs.domain.auth.DefaultSignInWithEmailAndPassword
import io.spherelabs.domain.auth.EmailValidation
import io.spherelabs.domain.auth.NameValidation
import io.spherelabs.domain.auth.PasswordValidation
import io.spherelabs.domain.auth.SignInWithEmailAndPassword
import io.spherelabs.domain.auth.ValidateEmail
import io.spherelabs.domain.auth.ValidateName
import io.spherelabs.domain.auth.ValidatePassword
import io.spherelabs.domain.onboarding.DefaultIsFirstTime
import io.spherelabs.domain.onboarding.DefaultSetIsFirstTime
import io.spherelabs.domain.onboarding.IsFirstTime
import io.spherelabs.domain.onboarding.SetIsFirstTime
import org.koin.dsl.module

val domainModule = module {
    single<SetIsFirstTime> { DefaultSetIsFirstTime(get()) }
    single<IsFirstTime> { DefaultIsFirstTime(get()) }
    single<CreateEmailAndPassword> { DefaultCreateEmailAndPassword(get()) }
    single<SignInWithEmailAndPassword> { DefaultSignInWithEmailAndPassword(get()) }
    single<EmailValidation> { ValidateEmail() }
    single<NameValidation> { ValidateName()  }
    single<PasswordValidation> { ValidatePassword()  }
}