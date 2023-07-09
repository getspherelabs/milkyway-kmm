package io.spherelabs.auth.signup

import io.spherelabs.domain.auth.EmailValidation
import io.spherelabs.domain.auth.NameValidation
import io.spherelabs.domain.auth.PasswordValidation
import io.spherelabs.meteor.middleware.Middleware

class ValidateMiddleware(
    private val validateName: NameValidation,
    private val validatePassword: PasswordValidation,
    private val validateEmail: EmailValidation
): Middleware<SignUpState, SignUpWish> {

    override suspend fun process(
        state: SignUpState,
        wish: SignUpWish,
        next: suspend (SignUpWish) -> Unit
    ) {
        when(wish) {
            SignUpWish.OnSignUpClick -> {
                if (state.email.isNotEmpty() && !validateEmail.execute(state.email)) {
                    next.invoke(SignUpWish.OnEmailFailed)
                }
                if (state.password.isNotEmpty() && !validatePassword.execute(state.password)) {
                    next.invoke(SignUpWish.OnPasswordFailed)
                }
                if (state.name.isNotEmpty() && !validateName.execute(state.name)) {
                    next.invoke(SignUpWish.OnNameFailed)
                }

                if (state.name.isNotEmpty()
                    && state.password.isNotEmpty()
                    && state.name.isNotEmpty()
                ) {
                    if (!state.emailFailed && !state.nameFailed && !state.passwordFailed) {
                        next.invoke(SignUpWish.SignUp)
                    }
                }
            }
            else -> {}
        }
    }
}