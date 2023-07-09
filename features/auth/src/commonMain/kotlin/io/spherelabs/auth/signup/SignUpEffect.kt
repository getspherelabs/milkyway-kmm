package io.spherelabs.auth.signup

sealed interface SignUpEffect {
    data class Failure(val message: String): SignUpEffect
    object SignIn: SignUpEffect
    object Discover: SignUpEffect
}