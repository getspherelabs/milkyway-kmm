package io.spherelabs.auth.signup

import io.spherelabs.domain.auth.CreateEmailAndPassword
import io.spherelabs.domain.auth.EmailValidation
import io.spherelabs.domain.auth.NameValidation
import io.spherelabs.domain.auth.PasswordValidation
import io.spherelabs.meteor.middleware.Middleware

class SignUpMiddleware(
    private val createEmailAndPassword: CreateEmailAndPassword,
) : Middleware<SignUpState, SignUpWish> {

    override suspend fun process(
        state: SignUpState,
        wish: SignUpWish,
        next: suspend (SignUpWish) -> Unit
    ) {
        when (wish) {
            SignUpWish.SignUp -> {
                val result = createEmailAndPassword.execute(state.email, state.password)

                result.onSuccess {
                    next.invoke(SignUpWish.SignUpSuccess)
                }.onFailure { newException ->
                    val failureMsg = newException.message ?: "Error is occurred!"
                    next.invoke(SignUpWish.SignUpFailure(failureMsg))
                }
            }

            else -> {}
        }
    }
}